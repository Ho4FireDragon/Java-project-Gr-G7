package com.shopkoi.shopkoi.Service;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.shopkoi.shopkoi.dto.AuthenticationRequest;
import com.shopkoi.shopkoi.dto.IntrospectRequest;
import com.shopkoi.shopkoi.dto.response.AuthenticationResponse;
import com.shopkoi.shopkoi.dto.response.IntrospectResponse;
import com.shopkoi.shopkoi.model.entity.Staff;
import com.shopkoi.shopkoi.repository.CustomerRepository;
import com.shopkoi.shopkoi.repository.StaffRepository;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AuthenticationService {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    public AuthenticationResponse authenticateStaff(AuthenticationRequest authenticationRequest) throws JOSEException {
        var staffemail = staffRepository.findByStaffemail(authenticationRequest.getEmail()).orElse(null);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), staffemail.getStaffpassword());

        if (!authenticated) {
            throw new JOSEException("Invalid password");
        }
        var token = generateToken(authenticationRequest.getEmail());

        return AuthenticationResponse.builder()
                    .token(token)
                    .build();
    }

    public AuthenticationResponse authenticateCustomer(AuthenticationRequest authenticationRequest) throws JOSEException {
        var customeremail = customerRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), customeremail.getPassword());

        if (!authenticated) {
            throw new JOSEException("Invalid password");
        }
        var token = generateToken(authenticationRequest.getEmail());

        return AuthenticationResponse.builder()
                .Id(customeremail.getId())
                .Name(customeremail.getFirstname())
                .Email(customeremail.getEmail())
                .Address(customeremail.getAddress())
                .Phone(customeremail.getPhone())
                .token(token)
                .build();
    }

    @NonFinal
    protected static final String SIGNER_KEY = "bJAlGYJC+G5iUfD2OQv6u0fWXOeV67Dz0uz+O9BIlgOA1At7QEp/Zh9eqXUUoU+K\n";

    private String generateToken(String email) throws JOSEException {
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(email)
                .issuer("ShopKoi.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(3, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim("staffId", "staff")
                .build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject= new JWSObject(jwsHeader, payload);

        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Cannot create token", e);
            throw new RuntimeException(e);
        }
    }

    public IntrospectResponse introspectCustomer(IntrospectRequest introspectRequest) throws JOSEException, ParseException {
        var token = introspectRequest.getToken();

        JWSVerifier verifier = new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expityTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier); //True or

        return  IntrospectResponse.builder()
                .valid(verified && expityTime.after(new Date()))
                .build();

    }
}

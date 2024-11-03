package com.shopkoi.shopkoi.Service;

import com.shopkoi.shopkoi.dto.AuthenticationRequest;
import com.shopkoi.shopkoi.model.entity.Staff;
import com.shopkoi.shopkoi.repository.CustomerRepository;
import com.shopkoi.shopkoi.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private StaffRepository staffRepository;

    public boolean authenticateStaff(AuthenticationRequest authenticationRequest) {
        var staffemail = staffRepository.findByStaffemail(authenticationRequest.getEmail()).orElse(null);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(authenticationRequest.getPassword(), staffemail.getStaffpassword());
    }

    public boolean authenticateCustomer(AuthenticationRequest authenticationRequest) {
        var customeremail = customerRepository.findByEmail(authenticationRequest.getEmail()).orElse(null);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(authenticationRequest.getPassword(), customeremail.getPassword());
    }
}

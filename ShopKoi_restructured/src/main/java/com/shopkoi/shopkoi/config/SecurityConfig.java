package com.shopkoi.shopkoi.config;

import com.shopkoi.shopkoi.Service.Right;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomJwtDecoder jwtDecoder;

    private final String[] PublicEndpoints = {"/api/customers/create",
            "/api/auth/login-staff",
            "/api/auth/login-customer",
            "/api/auth/logout-customer",
            "/api/auth/logout-staff",
            "/api/auth/introspect-customer",
            "/api/auth/introspect-staff",
            "/api/staff/create",
            "/api/auth/refreshtoken",
            "/api/roles/create"
    };

    private final String[] AdminGetEndpoints = {"/api/customers",
            "/api/customers/{id}",
            "/api/staff",
            "/api/staff/{id}",
            "/api/blog",
            "/api/blog/{id}",
            "/api/blogslug",
            "/api/bookings",
            "/api/books/{id}",
            "/api/feedback",
            "/api/feedback/{id}",
            "/api/roles",
            "/api/roles/{id}",
            "/api/services"
    };

    private final String[] AdminDeleteEndpoints = {"/api/customers/delete",
    "/api/staff/delete",

    };

    private final String[] AdminPutEndpoints = {"/api/customers/update",
            "/api/staff/update",
            "/api/roles/update",
            "/api/services/update",
            "/api/feedback/update",
            "/api/blog/update",
    };

    @NonFinal
    protected static final String SIGNER_KEY = "bJAlGYJC+G5iUfD2OQv6u0fWXOeV67Dz0uz+O9BIlgOA1At7QEp/Zh9eqXUUoU+K\n";

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(request ->
                request.requestMatchers(HttpMethod.POST,PublicEndpoints).permitAll()
                        .requestMatchers(HttpMethod.GET,AdminGetEndpoints).hasAnyAuthority("SCOPE_ADMIN")
                        .requestMatchers(HttpMethod.DELETE,AdminDeleteEndpoints).hasRole(Right.ADMIN.name())
                        .requestMatchers(HttpMethod.PUT,AdminPutEndpoints).hasRole(Right.ADMIN.name())
                        .anyRequest().authenticated());
                httpSecurity.oauth2ResourceServer(login ->
                        login.jwt(jwtConfigurer -> jwtConfigurer.decoder(jwtDecoder))
                );

        httpSecurity.csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable());
        return httpSecurity.build();
    }

//    @Bean
//    JwtDecoder jwtDecoder() {
//        SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
//        return NimbusJwtDecoder.withSecretKey(secretKeySpec)
//                .macAlgorithm(MacAlgorithm.HS512)
//                .build();
//    };

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("admin").password(passwordEncoder().encode("1234")).roles("USER");
        return authenticationManagerBuilder.build();
    }
}

package com.shopkoi.shopkoi.controller;

import com.shopkoi.shopkoi.Service.AuthenticationService;
import com.shopkoi.shopkoi.dto.AuthenticationRequest;
import com.shopkoi.shopkoi.dto.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/login-staff")
    private ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.authenticateStaff(authenticationRequest);
        AuthenticationResponse response;

        if (result) {
            // Xác thực thành công
            response = new AuthenticationResponse("Login successful", true);
            return ResponseEntity.ok(response);
        } else {
            // Xác thực thất bại
            response = new AuthenticationResponse("Invalid credentials", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


    @PostMapping("/login-customer")
    private ResponseEntity<AuthenticationResponse> authenticatecustomer(@RequestBody AuthenticationRequest authenticationRequest) {
        boolean result = authenticationService.authenticateCustomer(authenticationRequest);
        AuthenticationResponse response;

        if (result) {
            // Xác thực thành công
            response = new AuthenticationResponse("Login successful", true);
            return ResponseEntity.ok(response);
        } else {
            // Xác thực thất bại
            response = new AuthenticationResponse("Invalid credentials", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }




}

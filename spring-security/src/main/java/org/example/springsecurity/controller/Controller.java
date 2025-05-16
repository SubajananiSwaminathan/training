package org.example.springsecurity.controller;

import org.example.springsecurity.dto.request.AuthRequest;
import org.example.springsecurity.dto.response.AuthResponse;
import org.example.springsecurity.security.JWTUtil;
import org.example.springsecurity.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/home")
    public String home() {
        return "this is home page";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "this is dashboard page";
    }

    @GetMapping("/manage")
    public String manage() {
        return "this is manage page";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid username or password");
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthResponse(jwt);
    }
}

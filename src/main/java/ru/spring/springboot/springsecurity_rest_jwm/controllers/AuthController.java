package ru.spring.springboot.springsecurity_rest_jwm.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.spring.springboot.springsecurity_rest_jwm.dtos.JwtRequest;
import ru.spring.springboot.springsecurity_rest_jwm.dtos.RegistrationUserDto;
import ru.spring.springboot.springsecurity_rest_jwm.service.AuthService;
import ru.spring.springboot.springsecurity_rest_jwm.utils.JwtTokenUtils;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/registration")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }
}

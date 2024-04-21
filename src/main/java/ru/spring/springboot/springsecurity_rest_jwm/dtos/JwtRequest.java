package ru.spring.springboot.springsecurity_rest_jwm.dtos;

import lombok.Data;

@Data
public class JwtRequest {
    private String username;
    private String password;
}

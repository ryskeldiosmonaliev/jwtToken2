package com.example.jwttoken2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class LoginResponse {

    private String jwtToken;
    private String messages;
    private Set<String> authorities;
}

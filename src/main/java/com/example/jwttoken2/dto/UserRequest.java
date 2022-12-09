package com.example.jwttoken2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
//@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserRequest {

    private String name;
    private String surname;
    private String email;
    private String password;
}

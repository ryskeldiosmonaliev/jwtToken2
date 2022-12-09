package com.example.jwttoken2.dto.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    private String companyName;
    @NotNull
    private String locatedCountry;

}

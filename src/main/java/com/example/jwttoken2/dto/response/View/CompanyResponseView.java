package com.example.jwttoken2.dto.response.View;

import com.example.jwttoken2.dto.response.CompanyResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class CompanyResponseView {
    List<CompanyResponse> companyResponses;
}

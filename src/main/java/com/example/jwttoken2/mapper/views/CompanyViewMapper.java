package com.example.jwttoken2.mapper.views;

import com.example.jwttoken2.dto.response.CompanyResponse;
import com.example.jwttoken2.entity.Company;
import org.springframework.stereotype.Component;


@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }

        CompanyResponse response = new CompanyResponse();
        if (company.getId() != null) {
            response.setId(company.getId());
        }

        response.setCompanyName(company.getCompanyName());
        response.setLocatedCountry(company.getLocatedCountry());
        return response;
    }
}

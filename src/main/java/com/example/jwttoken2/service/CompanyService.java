package com.example.jwttoken2.service;

import com.example.jwttoken2.dto.request.CompanyRequest;
import com.example.jwttoken2.dto.response.CompanyResponse;
import com.example.jwttoken2.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    void deleteCompanyById(Long id);
}

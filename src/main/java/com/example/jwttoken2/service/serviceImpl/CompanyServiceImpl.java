package com.example.jwttoken2.service.serviceImpl;

import com.example.jwttoken2.dto.request.CompanyRequest;
import com.example.jwttoken2.dto.response.CompanyResponse;
import com.example.jwttoken2.entity.Company;
import com.example.jwttoken2.mapper.edit.CompanyEditMapper;
import com.example.jwttoken2.mapper.views.CompanyViewMapper;
import com.example.jwttoken2.repository.CompanyRepository;
import com.example.jwttoken2.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyEditMapper editMapper;
    private final CompanyViewMapper viewMapper;

    @Override
    public List<Company> getAllCompany() {
        return repository.findAll();
    }

    @Override

    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        return viewMapper.viewCompany(repository.save(editMapper.create(companyRequest)));
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = repository.findById(id).get();
        editMapper.update(company, companyRequest);
        Company company1 = repository.findById(id).get();
        return viewMapper.viewCompany(company1);
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        return viewMapper.viewCompany(repository.findById(id).get());
    }

    @Override
    public void deleteCompanyById(Long id) {
        repository.deleteById(id);
    }
}

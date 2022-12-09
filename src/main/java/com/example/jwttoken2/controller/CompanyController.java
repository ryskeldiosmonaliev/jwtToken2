package com.example.jwttoken2.controller;

import com.example.jwttoken2.dto.request.CompanyRequest;
import com.example.jwttoken2.dto.response.CompanyResponse;
import com.example.jwttoken2.entity.Company;
import com.example.jwttoken2.service.CompanyService;
import com.example.jwttoken2.service.serviceImpl.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
@Tag(name = "Company Api",description = "company add, update, delete")
public class CompanyController {

    private final CompanyService companyService;
    private final StudentServiceImpl studentService;

    @GetMapping
    @Operation(summary = "find all company",description = "we can get all company")
    public List<Company> findAllCompany() {
        return companyService.getAllCompany();
    }

    @GetMapping("/{id}")
    @Operation(summary = "find by id",description =
    "we can find company by id")
    public CompanyResponse findById(@PathVariable  Long id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("/count")
    @Operation(summary = "count",description ="how  much student" )
    public Long countById(Long id){
        return studentService.countById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "save company",description = "we can creat compny")
    public CompanyResponse saveCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @PatchMapping("update/{id}")
    @Operation(summary = "update company",description = "we can update compny")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id,companyRequest);
    }

    @DeleteMapping("delete/{id}")
    @Operation(summary = "delete copany",description = "we can delete company")
    public void deleteCompanyById(@PathVariable("id") Long id) {
        companyService.deleteCompanyById(id);
    }

}


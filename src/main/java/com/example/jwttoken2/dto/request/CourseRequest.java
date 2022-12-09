package com.example.jwttoken2.dto.request;

import com.example.jwttoken2.entity.Company;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequest {

    @NotNull
    private String courseName;
    @NotNull
    private String durationMonth;
    private Company company;
    private Long companyId;

}

package com.example.jwttoken2.dto.request;

import com.example.jwttoken2.entity.Courses;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TeacherRequest {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;

    private Courses courses;

    Long courseId;
}

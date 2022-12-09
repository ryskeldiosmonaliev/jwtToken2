package com.example.jwttoken2.dto.request;

import com.example.jwttoken2.entity.Courses;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;


@Getter
@Setter
public class GroupRequest {

    @NotNull
    private String groupName;
    @NotNull
    private String dateOfStart;
    @NotNull
    private  String dateOfFinish;
    private Long courseId;
    private List<Courses> courses;

}

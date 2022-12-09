package com.example.jwttoken2.dto.response;

import com.example.jwttoken2.entity.Groups;
import com.example.jwttoken2.entity.StudyFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentResponse {

    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private Groups groups;
    private Long groupId;
    private StudyFormat studyFormat;
}

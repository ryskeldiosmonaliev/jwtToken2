package com.example.jwttoken2.dto.response.View;

import com.example.jwttoken2.dto.response.StudentResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentResponseView {

    private List<StudentResponse> responses;
}

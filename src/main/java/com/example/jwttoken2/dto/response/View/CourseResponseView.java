package com.example.jwttoken2.dto.response.View;

import com.example.jwttoken2.dto.response.CourseResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class CourseResponseView {
    List<CourseResponse> courseResponses;
}

package com.example.jwttoken2.controller;

import com.example.jwttoken2.dto.request.TeacherRequest;
import com.example.jwttoken2.dto.response.TeacherResponse;
import com.example.jwttoken2.entity.Teacher;
import com.example.jwttoken2.service.serviceImpl.CoursesServiceImpl;
import com.example.jwttoken2.service.serviceImpl.StudentServiceImpl;
import com.example.jwttoken2.service.serviceImpl.TeacherServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
@Tag(name = "Teacher Api",description = "update, delete , save teahers")
public class TeacherController {

    private final CoursesServiceImpl courserService;
    private final TeacherServiceImpl teacherService;
    private final StudentServiceImpl studentService;

    @PostMapping
    @Operation(summary = "create teacher", description = "we can create teacher")
    public Teacher create(@RequestBody TeacherRequest request){
        return teacherService.create(request, request.getCourseId());
    }

    @PutMapping("{id}")
    @Operation(summary = "update teacher", description = "we can update teacher")
    public TeacherResponse update(@PathVariable Long id, @RequestBody TeacherRequest request){
        return teacherService.update(id, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete teacher", description = "we can delete teacher")
    public void deleteById(@PathVariable Long id){
        teacherService.deleteById(id);
    }

    @GetMapping("{id}")
    @Operation(summary = "get teacher by id", description = "we can get teacher by id")
    public TeacherResponse getById(@PathVariable Long id){
        return teacherService.getById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "get all teacher", description = "we can get all teacher")
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }
    @GetMapping("/count/{id}")
    public Long countByIdT(@PathVariable("id") Long id) {
        teacherService.getById(id);
        return studentService.countByIdT(id);
    }
}




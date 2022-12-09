package com.example.jwttoken2.controller;

import com.example.jwttoken2.dto.request.CourseRequest;
import com.example.jwttoken2.dto.response.CourseResponseView;
import com.example.jwttoken2.entity.Courses;
import com.example.jwttoken2.service.serviceImpl.CoursesServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
@Tag(name = "Course Api",description = "add, udate, delete course")
public class CoursesController {

    private final CoursesServiceImpl courserService;
    @PostMapping
    @Operation(summary = "create courses", description = "we can create course")
    public Courses create(@RequestBody CourseRequest request){
        return courserService.create(request, request.getCompanyId());
    }

    @PutMapping("{id}")
    @Operation(summary = "update course", description = "we can update course")
    public Courses update(@PathVariable Long id, @RequestBody CourseRequest request){
        return courserService.update(id, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete course", description = "we can delete course")
    public void deleteById(@PathVariable Long id){
        courserService.deleteById(id);
    }

    @GetMapping("{id}")
    @Operation(summary = "get course by id", description = "we can get course by id")
    public Courses getById(@PathVariable Long id){
        return courserService.getById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "get all students", description = "we can get all students")
    public List<Courses> getAllStudents(){
        return courserService.getAllStudents();
    }

    @GetMapping
    public CourseResponseView getAll(@RequestParam(name = "text", required = false) String text,
                                     @RequestParam int page,
                                     @RequestParam int size){
        return courserService.getAllStudentsPagination(text, page, size);

    }

}

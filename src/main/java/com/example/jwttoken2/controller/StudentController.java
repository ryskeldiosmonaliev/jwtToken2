package com.example.jwttoken2.controller;

import com.example.jwttoken2.dto.request.StudentRequest;
import com.example.jwttoken2.dto.response.StudentResponse;
import com.example.jwttoken2.entity.Student;
import com.example.jwttoken2.service.serviceImpl.GroupsServiceImpl;
import com.example.jwttoken2.service.serviceImpl.StudentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@Tag(name = "Student API",
        description = "User with role admin, editor can add, update, delete or get all students")
public class StudentController {
    private final StudentServiceImpl studentService;
    private final GroupsServiceImpl groupService;

    @Autowired
    public StudentController(StudentServiceImpl studentService, GroupsServiceImpl groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }
    @PostMapping
    @Operation(summary = "create student", description = "we can create student")
    public Student create(@RequestBody StudentRequest request){
        return studentService.create(request, request.getGroupId());
    }

    @PutMapping("{id}")
    @Operation(summary = "update student", description = "we can update student")
    public StudentResponse update(@PathVariable Long id, @RequestBody StudentRequest request){
        return studentService.update(id, request);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "delete student", description = "we can delete student")
    public void deleteById(@PathVariable Long id){
        studentService.deleteById(id);
    }

    @GetMapping("{id}")
    @Operation(summary = "get student by id", description = "we can get student by id")
    public StudentResponse getById(@PathVariable Long id){
        return studentService.getById(id);
    }

    @GetMapping("/all")
    @Operation(summary = "get all students", description = "we can get all students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

//    @GetMapping
//    public StudentResponseView getAll(@RequestParam(name = "text", required = false) String text,
//                                      @RequestParam int page,
//                                      @RequestParam int size){
//        return studentService.getAllStudentsPagination(text, page, size);
//
//    }
}


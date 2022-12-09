package com.example.jwttoken2.controller;

import com.example.jwttoken2.entity.Groups;
import com.example.jwttoken2.service.serviceImpl.CoursesServiceImpl;
import com.example.jwttoken2.service.serviceImpl.GroupsServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@Tag(name = "Grpup Api", description = "update, add , delete Group")
@RequiredArgsConstructor
public class GroupController {

    private final CoursesServiceImpl courserService;
    private final GroupsServiceImpl groupService;

    @GetMapping
    @Operation(summary = "get all Group",description = "we can get all Groups")
    public List<Groups> getAllGroups() {
        return groupService.findAllGroups();
    }

    @GetMapping("/{id}")
    @Operation(summary = "find by id group",description = "we can find Group by id")
    public Groups findByIdGroups(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    @Operation(summary = "save group",description = "we can creat group")
    public Groups saveGroups( @RequestBody Groups group) {
        return groupService.saveGroups(group,group.getCourseId());
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "update group",description = "we can update groups")
    public Groups updateGroup(@RequestBody Groups groups, @PathVariable("id") Long courseId) {
        return groupService.updateGroups(groups,courseId);
    }

    @GetMapping("/search")
    @Operation(summary = "sears studend",description = "we can seach by name student")
    public String searchStudent(@RequestParam("student") String search) {
        return groupService.findByStudents(search).toString();


    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "delete group",description = "we can delete groups")
    public void deleteGroupsById(@PathVariable("id") Long id) {
        groupService.deleteById(id);
    }
}


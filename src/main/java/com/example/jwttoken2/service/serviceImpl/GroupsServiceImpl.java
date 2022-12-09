package com.example.jwttoken2.service.serviceImpl;

import com.example.jwttoken2.entity.Courses;
import com.example.jwttoken2.entity.Groups;
import com.example.jwttoken2.entity.Student;
import com.example.jwttoken2.repository.CoursesRepository;
import com.example.jwttoken2.repository.GroupsRepository;
import com.example.jwttoken2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class GroupsServiceImpl{

    private final StudentRepository studentRepository;
    private final StudentServiceImpl studentService;
    private final GroupsRepository groupsRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public GroupsServiceImpl(GroupsRepository groupsRepository, CoursesRepository coursesRepository, StudentRepository studentRepository, StudentServiceImpl studentService) {
        this.groupsRepository = groupsRepository;
        this.coursesRepository = coursesRepository;
        this.studentRepository=studentRepository;
        this.studentService = studentService;
    }
    public List<Groups> findAllGroups() {
        return groupsRepository.findAll();
    }

    public Groups saveGroups(Groups groups, Long courseId) {
        Courses courses = coursesRepository.findById(courseId).get();
        groups.setCourses(Collections.singletonList(courses));
        return groupsRepository.save(groups);
    }


    public Groups findById(Long id) {
        return groupsRepository.findById(id).get();
    }

    public Groups updateGroups(Groups newGroups, Long coursesId) {
        Groups groups = findById(coursesId);
        groups.setGroupName(newGroups.getGroupName());
        groups.setDateOfStart(newGroups.getDateOfStart());
        groups.setDateOfFinish(newGroups.getDateOfFinish());
        groups.setCourseId(newGroups.getCourseId());
        return groupsRepository.save(groups);
    }


    public List<Student> findByStudents(String search) {
        if (search !=null){
            return groupsRepository.findByStudents(search);
        }
        return  studentRepository.findAll();
    }

    public void deleteById(Long id) {
        groupsRepository.deleteById(id);
    }
}



package com.example.jwttoken2.service.serviceImpl;

import com.example.jwttoken2.dto.request.TeacherRequest;
import com.example.jwttoken2.dto.response.TeacherResponse;
import com.example.jwttoken2.entity.Courses;
import com.example.jwttoken2.entity.Teacher;
import com.example.jwttoken2.repository.CoursesRepository;
import com.example.jwttoken2.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl  {

    private final TeacherRepository teacherRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository, CoursesRepository coursesRepository) {
        this.teacherRepository = teacherRepository;
        this.coursesRepository = coursesRepository;
    }
    public Teacher create(TeacherRequest request, Long coursesId){
        Courses courses = coursesRepository.findById(coursesId).get();
        request.setCourses(courses);
        Teacher teacher = mapToEntity(request);
      return   teacherRepository.save(teacher);

    }

    public TeacherResponse update(Long id, TeacherRequest request) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isEmpty()){
            System.out.println("teacher id not found");
        }
        mapToUpdateTeacher(teacher.get(),request);
        return teacherResponse(teacherRepository.save(teacher.get()));
    }

    public TeacherResponse getById(Long id) {
        Teacher teacher= teacherRepository.findById(id).get();
        return teacherResponse(teacher);
    }

    public void deleteById(Long id) {
        Teacher teacher = teacherRepository.findById(id).get();
        teacherRepository.delete(teacher);
    }

    public Teacher mapToEntity(TeacherRequest request) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setCourseId(request.getCourseId());

        return teacher;
    }

    public void mapToUpdateTeacher(Teacher teacher,TeacherRequest request) {
        teacher.setFirstName(request.getFirstName());
        teacher.setLastName(request.getLastName());
        teacher.setEmail(request.getEmail());
        teacher.setCourseId(request.getCourseId());
    }

    public TeacherResponse teacherResponse(Teacher teacher) {
        return TeacherResponse.builder()
                .id(teacher.getId())
                .firstName(teacher.getFirstName())
                .lastName(teacher.getLastName())
                .email(teacher.getEmail())
                .courseId(teacher.getCourseId())
                .build();
    }

    public List<Teacher> getAllTeacher() {

        return teacherRepository.findAll();
    }
}

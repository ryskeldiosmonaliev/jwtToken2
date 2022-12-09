package com.example.jwttoken2.service.serviceImpl;

import com.example.jwttoken2.dto.request.CourseRequest;
import com.example.jwttoken2.dto.response.CourseResponse;
import com.example.jwttoken2.dto.response.CourseResponseView;
import com.example.jwttoken2.entity.Company;
import com.example.jwttoken2.entity.Courses;
import com.example.jwttoken2.repository.CompanyRepository;
import com.example.jwttoken2.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImpl {
    private final CompanyRepository companyRepository;
    private final CoursesRepository coursesRepository;

    @Autowired
    public CoursesServiceImpl(CompanyRepository companyRepository, CoursesRepository coursesRepository) {
        this.companyRepository = companyRepository;
        this.coursesRepository = coursesRepository;
    }

    public Courses create(CourseRequest request, Long companyId){
        Company company = companyRepository.findById(companyId).get();
        request.setCompany(company);
        Courses courses = mapToEntity(request);
     return    coursesRepository.save(courses);

    }

    public Courses update(Long id, CourseRequest request) {
        Optional<Courses> courses =coursesRepository.findById(id);
        if (courses.isEmpty()){
            System.out.println("Course id not found");
        }
        mapToUpdateCourse(courses.get(),request);
        return coursesRepository.save(courses.get());
    }

    public Courses getById(Long id) {
       return coursesRepository.findById(id).get();

    }

    public void deleteById(Long id) {
        Courses courses = coursesRepository.findById(id).get();
        coursesRepository.delete(courses);
    }

    public Courses mapToEntity(CourseRequest request) {
        Courses courses = new Courses();
        courses.setCourseName(request.getCourseName());
        courses.setDuration(request.getDurationMonth());
        courses.setCompanyId(request.getCompanyId());
        return courses;
    }

    public void mapToUpdateCourse(Courses courses, CourseRequest request) {
        courses.setCourseName(request.getCourseName());
        courses.setDuration(request.getDurationMonth());
        courses.setCompanyId(request.getCompanyId());

    }

    public CourseResponse studentResponse(Courses courses) {
        return CourseResponse.builder()
                .id(courses.getId())
                .courseName(courses.getCourseName())
                .durationMonth(courses.getDuration())
                .build();
    }

    public List<Courses> getAllStudents() {

        return coursesRepository.findAll();
    }


    public CourseResponseView getAllStudentsPagination(String text, int page, int size){
        CourseResponseView responseView = new CourseResponseView();
        PageRequest pageable =  PageRequest.of(page -1, size);
        return responseView;
    }


}



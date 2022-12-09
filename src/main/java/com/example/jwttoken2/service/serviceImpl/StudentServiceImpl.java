package com.example.jwttoken2.service.serviceImpl;

import com.example.jwttoken2.dto.request.StudentRequest;
import com.example.jwttoken2.dto.response.StudentResponse;
import com.example.jwttoken2.entity.Groups;
import com.example.jwttoken2.entity.Student;
import com.example.jwttoken2.repository.GroupsRepository;
import com.example.jwttoken2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl {
    private final StudentRepository studentRepository;
    private final GroupsRepository groupsRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, GroupsRepository groupsRepository) {
        this.studentRepository = studentRepository;
        this.groupsRepository = groupsRepository;
    }
    public Student create(StudentRequest request, Long groupId){
        Groups groups = groupsRepository.findById(groupId).get();
        request.setGroups(groups);
        Student student = mapToEntity(request);
       return studentRepository.save(student);

    }

    public StudentResponse update(Long id, StudentRequest request) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()){
            System.out.println("Student id not found");
        }
        mapToUpdateStudent(student.get(),request);
        return studentResponse(studentRepository.save(student.get()));
    }

    public StudentResponse getById(Long id) {
        Student student = studentRepository.findById(id).get();
        return studentResponse(student);
    }
    public Long countById(Long id) {
        return studentRepository.count();
    }

    public List<Student> findStudentWithSort(String sorting) {
        return studentRepository.findAll(Sort.by(Sort.Direction.ASC,sorting));
    }

    public Long countByIdT(Long id) {
        return studentRepository.countByIdT(id);
    }

    public void deleteById(Long id) {
        Student student = studentRepository.findById(id).get();
        studentRepository.delete(student);
    }

    public Student mapToEntity(StudentRequest request) {
        Student student = new Student();
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setEmail(request.getEmail());
        student.setStudyFormat(request.getStudyFormat());
        student.setGroupId(request.getGroupId());
        return student;
    }

    public void mapToUpdateStudent(Student student, StudentRequest request) {
      student.setFirstName(request.getFirstName());
      student.setLastName(request.getLastName());
      student.setEmail(request.getEmail());
      student.setStudyFormat(request.getStudyFormat());
      student.setGroupId(request.getGroupId());
    }

    public StudentResponse studentResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .studyFormat(student.getStudyFormat())
                .groupId(student.getGroupId())
                .build();
    }

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }





}

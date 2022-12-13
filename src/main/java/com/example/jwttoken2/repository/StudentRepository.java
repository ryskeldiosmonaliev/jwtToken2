package com.example.jwttoken2.repository;

import com.example.jwttoken2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

//
    @Query("SELECT COUNT(s.groups.id) FROM Student s WHERE s.groups.id=?1")
    Long countByIdTeacher(Long id);

    @Override
    long count();

}

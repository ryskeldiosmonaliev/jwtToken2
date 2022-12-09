package com.example.jwttoken2.repository;

import com.example.jwttoken2.entity.Groups;
import com.example.jwttoken2.entity.Student;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, Long> {

    @Query("select s from Student s")
    List<Student>getByPagination(PageRequest pageRequest);

    @Query("SELECT s FROM Student s WHERE s.firstName LIKE %?1% " +
            "OR s.lastName LIKE %?1%")
    List<Student> findByStudents(String search);

}

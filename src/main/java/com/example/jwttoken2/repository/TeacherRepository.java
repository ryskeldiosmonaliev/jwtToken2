package com.example.jwttoken2.repository;

import com.example.jwttoken2.entity.Teacher;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Override
    <S extends Teacher> long count(Example<S> example);
}

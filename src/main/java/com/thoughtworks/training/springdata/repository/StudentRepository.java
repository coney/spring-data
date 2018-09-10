package com.thoughtworks.training.springdata.repository;

import com.thoughtworks.training.springdata.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByAgeLessThanEqual(Integer maxAge);

    List<Student> findByName(String name);
}

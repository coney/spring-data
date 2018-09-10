package com.thoughtworks.training.springdata.repository;

import com.thoughtworks.training.springdata.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}

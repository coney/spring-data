package com.thoughtworks.training.springdata.service;

import com.thoughtworks.training.springdata.exception.NotFoundException;
import com.thoughtworks.training.springdata.model.Student;
import com.thoughtworks.training.springdata.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student get(Integer id) {
        return Optional.ofNullable(studentRepository.findOne(id))
                .orElseThrow(NotFoundException::new);
    }

    public Integer create(Student student) {
        return studentRepository.save(student).getId();
    }

    public void delete(Integer id) {
        studentRepository.delete(id);
    }

    @Transactional
    public Student update(Integer id, Student student) {
        Student existOne = get(id);
        existOne.setAge(student.getAge());
        existOne.setName(student.getName());
        return studentRepository.save(existOne);
    }

    public List<Student> listByMaxAge(Integer maxAge) {
        return studentRepository.findByAgeLessThanEqual(maxAge);
    }

    public List<Student> listByName(String name) {
        return studentRepository.findByName(name);
    }
}

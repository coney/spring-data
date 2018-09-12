package com.thoughtworks.training.springdata.repository;

import com.thoughtworks.training.springdata.model.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void shouldFindStudentByName() {
        studentRepository.save(Student.builder()
                .name("xiaoming").age(12).build());

        List<Student> students = studentRepository.findByName("xiaoming");
        assertThat(students.size(), is(1));
        assertThat(students.get(0).getName(), is("xiaoming"));

        assertThat(studentRepository.findByName("daming").size(), is(0));
    }
}
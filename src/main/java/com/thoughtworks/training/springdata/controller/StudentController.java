package com.thoughtworks.training.springdata.controller;

import com.thoughtworks.training.springdata.model.Student;
import com.thoughtworks.training.springdata.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    List<Student> list() {
        return studentService.list();
    }

    @GetMapping(params = "name")
    List<Student> listByName(@RequestParam String name) {
        return studentService.listByName(name);
    }

    @GetMapping(params = "max-age")
    List<Student> listByMaxAge(@RequestParam("max-age") Integer maxAge) {
        return studentService.listByMaxAge(maxAge);
    }

    @PostMapping
    Integer create(@RequestBody Student student) {
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    Student get(@PathVariable Integer id) {
        return studentService.get(id);
    }
    @PutMapping("/{id}")
    Student update(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.update(id, student);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        studentService.delete(id);
    }
}

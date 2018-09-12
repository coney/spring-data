package com.thoughtworks.training.springdata.controller;

import com.thoughtworks.training.springdata.model.School;
import com.thoughtworks.training.springdata.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @RequestMapping(method = RequestMethod.GET)
    List<School> list() {
        return schoolService.list();
    }

    @GetMapping("/{id}")
    School get(@PathVariable Integer id) {
        return schoolService.get(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        schoolService.remove(id);
    }
}

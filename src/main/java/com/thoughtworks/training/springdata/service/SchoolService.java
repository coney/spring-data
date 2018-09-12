package com.thoughtworks.training.springdata.service;

import com.thoughtworks.training.springdata.exception.NotFoundException;
import com.thoughtworks.training.springdata.model.School;
import com.thoughtworks.training.springdata.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    public List<School> list() {
        return schoolRepository.findAll();
    }

    public School get(Integer id) {
        return Optional.ofNullable(schoolRepository.findOne(id))
                .orElseThrow(NotFoundException::new);
    }

    public void remove(Integer id) {
        schoolRepository.delete(schoolRepository.findOne(id));
    }
}

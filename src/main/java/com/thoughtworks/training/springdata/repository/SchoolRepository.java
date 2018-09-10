package com.thoughtworks.training.springdata.repository;

import com.thoughtworks.training.springdata.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}

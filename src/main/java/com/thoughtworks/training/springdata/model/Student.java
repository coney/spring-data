package com.thoughtworks.training.springdata.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Data
// Optional
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;

    // Optional
    @Column(name = "name")
    private String name;

    private Integer age;

    @Transient
    private String comments = "N/A";

    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonManagedReference
    private School school;
}

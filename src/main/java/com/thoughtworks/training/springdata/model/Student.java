package com.thoughtworks.training.springdata.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// Optional
@Table(name = "student")
@Where(clause = "deleted = 0")
@SQLDelete(sql = "UPDATE student SET deleted = 1 WHERE id = ?")
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "school_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private School school;
}

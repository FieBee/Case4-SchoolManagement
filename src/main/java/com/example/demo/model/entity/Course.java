package com.example.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "course")
public class Course {

    @Id
    private Long id;
    private Integer lessons;
    private String description;
    private String term;
    private Double price;

    @ManyToOne(targetEntity = Category.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(targetEntity = Class.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    private Student student;


}

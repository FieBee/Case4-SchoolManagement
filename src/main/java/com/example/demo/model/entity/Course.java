package com.example.demo.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

    @Id
    private Long id;
    private Integer lessons;
    private String description;
    private String term;


    public Course() {
    }

    public Course(Long id, Integer lessons, String description, String term) {
        this.id = id;
        this.lessons = lessons;
        this.description = description;
        this.term = term;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLessons() {
        return lessons;
    }

    public void setLessons(Integer lessons) {
        this.lessons = lessons;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", lessons=" + lessons +
                ", description='" + description + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}

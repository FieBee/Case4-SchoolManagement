package com.example.demo.model.entity;

import javax.persistence.*;

@Entity
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

    public Course(Long id, Integer lessons, String description, String term, Double price, Category category, Student student) {
        this.id = id;
        this.lessons = lessons;
        this.description = description;
        this.term = term;
        this.price = price;
        this.category = category;
        this.student = student;
    }

    public Course(Long id, Integer lessons, String description, String term, Double price, Student student) {
        this.id = id;
        this.lessons = lessons;
        this.description = description;
        this.term = term;
        this.price = price;
        this.student = student;
    }

    public Course() {
    }

    public Course(Long id, Integer lessons, String description, String term) {
        this.id = id;
        this.lessons = lessons;
        this.description = description;
        this.term = term;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
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

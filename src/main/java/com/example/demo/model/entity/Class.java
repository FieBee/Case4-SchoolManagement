package com.example.demo.model.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;

    @OneToMany(targetEntity = Payment.class,fetch = FetchType.EAGER)
    private List<Payment> payment;

    @OneToMany(targetEntity = Student.class,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    public Class() {
    }

    public Class(Long id, String name, LocalDate startDate, LocalDate endDate, Double price) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Class(Long id, String name, LocalDate startDate, LocalDate endDate, Double price, List<Payment> payment) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
    }

    public Class(Long id, String name, LocalDate startDate, LocalDate endDate, List<Payment> payment, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
        this.teacher = teacher;
    }


    public Class(Long id, String name, LocalDate startDate, LocalDate endDate, List<Payment> payment, List<Student> students, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.payment = payment;
        this.students = students;
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}



package com.example.demo.model.entity;

import com.example.demo.model.dto.AppRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birth;

    private String address;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String active;


    @OneToOne

    private Account account;

    @OneToMany(targetEntity = Course.class,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Course> courses;

    @ManyToOne(targetEntity = Class.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class classes;

    @OneToMany(targetEntity = Payment.class)
    private List<Payment> payment;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> appRole;

    private String image;

    public Student() {
    }

    public Student(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, Account account, List<Course> courses, Class classes, List<Payment> payment, Set<AppRole> appRole, String image) {
        this.id = id;
        this.birth = birth;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.account = account;
        this.courses = courses;
        this.classes = classes;
        this.payment = payment;
        this.appRole = appRole;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }

    public Set<AppRole> getAppRole() {
        return appRole;
    }

    public void setAppRole(Set<AppRole> appRole) {
        this.appRole = appRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


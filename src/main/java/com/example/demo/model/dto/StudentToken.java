package com.example.demo.model.dto;

import com.example.demo.model.dto.AppRole;
import com.example.demo.model.entity.Course;
import com.example.demo.model.entity.Payment;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class StudentToken {
    private Long id;
    private LocalDate birth;
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String active;
    private String account;
    private String password;
    private String token;

    private List<Course> courses;

    private Class classes;

    private List<Payment> payment;

    private Set<AppRole> appRole;

    private String image;


    public StudentToken() {
    }

    public StudentToken(Long id, String account, String token, Set<AppRole> appRole) {
        this.id = id;
        this.account = account;
        this.token = token;
        this.appRole = appRole;
    }

    public Set<AppRole> getAppRole() {
        return appRole;
    }

    public void setAppRole(Set<AppRole> appRole) {
        this.appRole = appRole;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


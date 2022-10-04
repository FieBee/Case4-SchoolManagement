package com.example.demo.model.entity;

import com.example.demo.model.dto.AppRole;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birth;
    @NotNull
    private String address;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String active;
    @NotEmpty
    private String account;
    @NotEmpty
    @Min(value = 5, message = "mật khẩu phải bao gồm 5 kí tự trở lên")
    private String password;

    @OneToMany(targetEntity = Course.class,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Course> courses;

    @ManyToOne(targetEntity = Class.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class classes;

    @OneToMany(targetEntity = Payment.class)
    private List<Payment> payment;
    @ManyToOne
    private AppRole appRole;

    private String image;


    public Student() {
    }

    public Student(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, String account, String password, List<Course> courses, Class classes, List<Payment> payment, AppRole appRole, String image) {
        this.id = id;
        this.birth = birth;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.account = account;
        this.password = password;
        this.courses = courses;
        this.classes = classes;
        this.payment = payment;
        this.appRole = appRole;
        this.image = image;
    }

    public Student(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, String account, String password, List<Course> courses, List<Payment> payment, AppRole appRole, String image) {
        this.id = id;
        this.birth = birth;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.account = account;
        this.password = password;
        this.courses = courses;
        this.payment = payment;
        this.appRole = appRole;
        this.image = image;
    }

    public Student(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, String account, String password, AppRole appRole, String image) {
        this.id = id;
        this.birth = birth;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.account = account;
        this.password = password;
        this.appRole = appRole;
        this.image = image;
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

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


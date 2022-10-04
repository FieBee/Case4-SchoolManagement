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
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate birth;
    @NotNull
    private String address;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    private String email;
    @NotEmpty
    private String phone;
    private String active;
    @NotEmpty
    private String account;
    @Min(value = 5, message = "mật khẩu phải bao gồm 5 kí tự trở lên")
    private String password;
    private String image;

    @OneToMany(targetEntity = Class.class,fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Class> classes;

    @ManyToOne
    private AppRole appRole;

    public Teacher() {
    }

    public Teacher(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, String account, String password, String image, List<Class> classes, AppRole appRole) {
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
        this.image = image;
        this.classes = classes;
        this.appRole = appRole;
    }

    public Teacher(Long id, LocalDate birth, String address, String firstName, String lastName, String email, String phone, String active, String account, String password, String image, AppRole appRole) {
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
        this.image = image;
        this.appRole = appRole;
    }


    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
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

    public AppRole getAppRole() {
        return appRole;
    }

    public void setAppRole(AppRole appRole) {
        this.appRole = appRole;
    }
}

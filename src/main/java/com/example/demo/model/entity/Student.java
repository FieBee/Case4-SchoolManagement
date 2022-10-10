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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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


    @OneToOne
    @NotEmpty
    private Account account;

    @OneToMany(targetEntity = Course.class)
//    @OneToMany(targetEntity = Course.class,fetch = FetchType.EAGER)
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



}


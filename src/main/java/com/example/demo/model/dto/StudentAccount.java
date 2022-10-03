package com.example.demo.model.dto;


import javax.persistence.*;

@Entity
@Table
public class StudentAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    alo
    private int studentId;
    private int active;
    private String account;
    private String password;

    public StudentAccount() {
    }

    public StudentAccount(int id, int studentId, int active, String account, String password) {
        this.id = id;
        this.studentId = studentId;
        this.active = active;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
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
}

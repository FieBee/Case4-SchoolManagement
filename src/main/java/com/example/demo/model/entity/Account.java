package com.example.demo.model.entity;

import com.example.demo.model.dto.AppRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    String account;
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> appRole;

    public Account() {
    }

    public Account(Long id, String account, String password, Set<AppRole> appRole) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.appRole = appRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<AppRole> getAppRole() {
        return appRole;
    }

    public void setAppRole(Set<AppRole> appRole) {
        this.appRole = appRole;
    }
}

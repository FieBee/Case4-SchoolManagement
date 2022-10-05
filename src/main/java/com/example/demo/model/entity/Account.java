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

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    String account;

    @NotEmpty
    @Min(value = 5, message = "mật khẩu phải bao gồm 5 kí tự trở lên")
    String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> appRole;

}

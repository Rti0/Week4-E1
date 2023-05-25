package com.example.week4_ex1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null unique")
    private String name;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;


    @NotEmpty
    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    @Column(columnDefinition = "varchar(30) not null")
    private String password;

    @Email
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
}

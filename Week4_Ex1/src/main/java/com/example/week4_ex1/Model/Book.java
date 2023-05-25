package com.example.week4_ex1.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @NotEmpty
    @Column(columnDefinition = "varchar(25) not null unique")
    private String title;


    @NotEmpty
    @Column(columnDefinition = "varchar(15) not null")
    private String author;

    @NotEmpty
    @Column(columnDefinition = "varchar(8) not null check(category='Academic' or category='Mystery' or category='Novel')")
    private String category;

    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer isbn;

    @NotNull
    @Min(value = 50,message = "pages minimum is 50 pages")
    @Column(columnDefinition = "int not null")
    private Integer numberOfPages;
}
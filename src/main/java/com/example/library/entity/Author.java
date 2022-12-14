package com.example.library.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "author")

public class Author {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "patronymic")
    private String patronymic;

    @Column (name = "surname")
    private String surname;




}

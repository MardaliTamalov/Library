package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AuthorDto {

    private String name;
    private String surname;
    private String patronymic;

}

package com.example.library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDto {

    private String name;
    private String surname;
    private String patronymic;

}

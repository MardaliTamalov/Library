package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AllValuesDto {

    private String name;
    private String surname;
    private String patronymic;

    private String title;
    private Integer yearIssue;

}

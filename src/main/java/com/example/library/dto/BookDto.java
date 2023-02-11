package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDto {

    private String title;
    private Integer yearIssue;

}

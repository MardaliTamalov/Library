package com.example.library.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class BookDto {

    private String author;

    private String title;

    private Integer yearIssue;

}

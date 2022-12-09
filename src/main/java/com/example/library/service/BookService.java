package com.example.library.service;

import com.example.library.dto.BookDto;
import com.example.library.dto.YearTitleBookDto;
import com.example.library.entity.Book;

import java.util.List;

public interface BookService {

    void changeYearIssue(YearTitleBookDto bookDto);

    void deleteBook(String bookDto);
    void addBook(BookDto bookDto);

    List<Book> getBooks(String author);
}

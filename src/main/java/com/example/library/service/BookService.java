package com.example.library.service;

import com.example.library.dto.AllValuesDto;
import com.example.library.dto.BookDto;

public interface BookService {
    void deleteBook(BookDto bookDto);
    void addBook(AllValuesDto allValuesDto);


}

package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.dto.YearTitleBookDto;
import com.example.library.entity.Book;
import com.example.library.service.BookService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor

public class ControllerLibrary {
    private final BookService bookService;


    @GetMapping("/book/{author}")
    public List<Book> getBooks(@PathVariable String author) {
        return bookService.getBooks(author);
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody BookDto book) {
        bookService.addBook(book);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/book")
    public ResponseEntity<?> putBook(@RequestBody YearTitleBookDto bookDto) {
        bookService.changeYearIssue(bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/book")
    public ResponseEntity<?> deleteBook(@RequestParam String author) {

        bookService.deleteBook(author);
        return ResponseEntity.ok().build();
    }
}

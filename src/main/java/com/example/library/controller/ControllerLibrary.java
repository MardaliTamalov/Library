package com.example.library.controller;

import com.example.library.dto.AllValuesDto;
import com.example.library.dto.AuthorDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.AuthorService;
import com.example.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
@RequiredArgsConstructor

public class ControllerLibrary {
    private final AuthorService authorService;
    private  final BookService bookService;
private final BookRepository bookRepository;


   // @GetMapping("/books/{surname}/{name}/{patronymic}")
    @GetMapping("/books")
    public List<Book> getBooks(@RequestParam String surname,@RequestParam String name, @RequestParam String patronymic)
     //       @PathVariable String surname, @PathVariable String name,@PathVariable String patronymic)
    {

        return bookRepository.getBooksByAuthorSurname(surname,name, patronymic);
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody AllValuesDto allValuesDto) {
        bookService.addBook(allValuesDto);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/book")
//    public ResponseEntity<?> putBook(@RequestBody BookDto bookDto) {
//        bookAuthorService.changeYearIssue(bookDto);
//        return ResponseEntity.ok().build();
//    }

    @DeleteMapping ("/book")
    public ResponseEntity<?> deleteBook(@RequestParam BookDto bookDto){

        bookService.deleteBook(bookDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping ("/author")
    public ResponseEntity<?> deleteAuthor(@RequestParam AuthorDto authorDto){

        authorService.deleteAuthor(authorDto);
        return ResponseEntity.ok().build();
    }
}

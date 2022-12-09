package com.example.library.repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> getBooksByAuthor(String author);


    Optional<Book> getBookByTitle(String title);

    Optional<Book>  getBookByAuthor(String author);
}

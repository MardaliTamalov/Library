package com.example.library.repository;

import com.example.library.dto.AllValuesDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

   Optional<Author> getAuthorByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);

    List<Author> getAuthorByName(String name);



}

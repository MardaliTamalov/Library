package com.example.library.service.impl;

import com.example.library.dto.AuthorDto;
import com.example.library.mapper.LibraryMapper;
import com.example.library.dto.AllValuesDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.AuthorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class AuthorServiceImpl implements AuthorService {
   private final AuthorRepository authorRepository;

    @Override
    @Transactional
    public void deleteAuthor(AuthorDto authorDto) {
        if(authorRepository.
                getAuthorByNameAndSurnameAndPatronymic(
                        authorDto.getName(),authorDto.getSurname(),authorDto.getPatronymic())
                        .isPresent()){

            authorRepository.delete(
            authorRepository.
                    getAuthorByNameAndSurnameAndPatronymic(
                            authorDto.getName(),authorDto.getSurname(),authorDto.getPatronymic()).get());

        }
    }
  }

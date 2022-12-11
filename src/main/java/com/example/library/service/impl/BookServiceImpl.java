package com.example.library.service.impl;

import com.example.library.dto.BookDto;
import com.example.library.dto.YearTitleBookDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements BookService {
private final BookRepository bookRepository;


    @Override
    @Transactional
    public void changeYearIssue(YearTitleBookDto bookDto) {
      if(bookRepository.getBookByTitle(bookDto.getTitle()).isPresent()){
          bookRepository.getBookByTitle(bookDto.getTitle()).get().setYearIssue(bookDto.getYearIssue());
      }

    }

    @Override
    @Transactional
    public void deleteBook(BookDto bookDto) {
        if(bookRepository.getBookByAuthor(bookDto).isPresent()){
           bookRepository.delete(bookRepository.getBookByAuthor(bookDto).get());
        }


    }

    @Override
    @Transactional
    public void addBook(BookDto bookDto) {
     Author author=new Author();
     author.setName(bookDto.getName());
     author.setSurname(bookDto.getSurname());
     author.setPatronymic(bookDto.getYearIssue());

     bookRepository.save(book);
    }

    
    @Override
    @Transactional
    public List<Book> getBooks(String author) {
        return bookRepository.getBooksByAuthor(author) ;
    }
}

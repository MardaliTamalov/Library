package com.example.library.service.impl;

import com.example.library.dto.BookDto;
import com.example.library.dto.YearTitleBookDto;
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
    public void deleteBook(String author) {
        if(bookRepository.getBookByAuthor(author).isPresent()){
           bookRepository.delete(bookRepository.getBookByAuthor(author).get());
        }


    }

    @Override
    @Transactional
    public void addBook(BookDto bookDto) {
     Book book=new Book();
     book.setAuthor(bookDto.getAuthor());
     book.setTitle(bookDto.getTitle());
     book.setYearIssue(bookDto.getYearIssue());

     bookRepository.save(book);
    }

    
    @Override
    @Transactional
    public List<Book> getBooks(String author) {
        return bookRepository.getBooksByAuthor(author) ;
    }
}

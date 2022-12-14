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
    private final LibraryMapper libraryMapper;
private final BookRepository bookRepository;
private final AuthorRepository authorRepository;


//    @Override
//    @Transactional
//    public void changeYearIssue(BookDto bookDto) {
//      if(bookRepository.getBookByTitle(bookDto.getTitle()).isPresent()){
//          bookRepository.getBookByTitle(bookDto.getTitle()).get().setYearIssue(bookDto.getYearIssue());
//      }

//    }

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

//                getBookByName(authorDto.getName()).isPresent()){
//           bookRepository.delete(authorRepository.getBookByName(authorDto.getName()).get());
//        }
    }



    @Override
    @Transactional
    public void addBook(AllValuesDto allValuesDto) {
       Author author = authorRepository
               .getAuthorByNameAndSurnameAndPatronymic(
                       allValuesDto.getName(), allValuesDto.getSurname(),allValuesDto.getPatronymic())
               .orElse(libraryMapper.getAuthor(allValuesDto));
       Book book =bookRepository
               .getBookByTitleAndYearIssue(allValuesDto.getTitle(), allValuesDto.getYearIssue())
               .orElse(libraryMapper.getBook(allValuesDto));
       book.setAuthor(author);
        bookRepository.save(book);

//     Author author=new Author();
//     if(authorRepository.
//             getAuthorByNameAndSurnameAndPatronymic(allValuesDto).isEmpty()){
//     author.setName(allValuesDto.getName());
//     author.setSurname(allValuesDto.getSurname());
//     author.setPatronymic(allValuesDto.getPatronymic());
//     authorRepository.save(author);}
//
//        Book book = new Book();
//        book.setTitle(allValuesDto.getTitle());
//        book.setYearIssue(allValuesDto.getYear());
//        bookRepository.save(book);
    }

    
  }

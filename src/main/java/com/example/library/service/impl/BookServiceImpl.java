package com.example.library.service.impl;

import com.example.library.dto.AllValuesDto;
import com.example.library.dto.BookDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import com.example.library.mapper.LibraryMapper;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.BookRepository;
import com.example.library.service.BookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final LibraryMapper libraryMapper;
    private final  AuthorRepository authorRepository;
   private final BookRepository bookRepository;

    @Override
    @Transactional
    public void deleteBook(BookDto bookDto) {
        if (bookRepository.getBookByTitleAndYearIssue(bookDto.getTitle(),bookDto.getYearIssue())
                .isPresent()){
            bookRepository.delete(
                    bookRepository.getBookByTitleAndYearIssue(
                            bookDto.getTitle(),bookDto.getYearIssue()).get());
        }
    }

    @Override
    @Transactional
    public void addBook(AllValuesDto allValuesDto) {
        Author author = authorRepository
                .getAuthorByNameAndSurnameAndPatronymic(
                        allValuesDto.getName(), allValuesDto.getSurname(), allValuesDto.getPatronymic())
                .orElse(libraryMapper.getAuthor(allValuesDto));
        Book book = bookRepository
                .getBookByTitleAndYearIssue(allValuesDto.getTitle(), allValuesDto.getYearIssue())
                .orElse(libraryMapper.getBook(allValuesDto));
        book.setAuthor(author);
        bookRepository.save(book);
    }

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
//    }
}

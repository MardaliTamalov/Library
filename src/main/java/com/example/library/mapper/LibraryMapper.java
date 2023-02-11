package com.example.library.mapper;

import com.example.library.dto.AllValuesDto;
import com.example.library.dto.AuthorDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface LibraryMapper {
 Author getAuthor(AllValuesDto allValuesDto);
 Book getBook(AllValuesDto allValuesDto);

 Author deleteAuthor(AuthorDto authorDto);


}

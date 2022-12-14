package com.example.library.repository;

import com.example.library.dto.AllValuesDto;
import com.example.library.entity.Author;
import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> getBookByTitleAndYearIssue(String title, Integer yearIssue);

@Query(value = """
select b from  Book b 
inner join Author a on a.id=b.author.id
where a.surname=:surname and a.name=:name and a.patronymic=:patronymic
""")
    List<Book> getBooksByAuthorSurname(String surname, String name, String patronymic );
}

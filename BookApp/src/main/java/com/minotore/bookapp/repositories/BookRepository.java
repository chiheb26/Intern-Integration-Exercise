package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findByLibraryName(String libName);
    List <Book> findByAuthorId(Long id);
}

package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findByName(String name);
}

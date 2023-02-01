package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library,Long> {
}

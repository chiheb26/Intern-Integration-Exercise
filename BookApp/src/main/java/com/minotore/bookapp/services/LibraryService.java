package com.minotore.bookapp.services;

import com.minotore.bookapp.dto.*;
import com.minotore.bookapp.models.Book;
import com.minotore.bookapp.models.Magazine;
import com.minotore.bookapp.models.Novel;

import java.util.List;


public interface LibraryService {
    List<BookDto> getAllBooksbyLibraryName(String libName);
    NovelDto getMostSoldNovelByAuthorId(Long id);
    MagazineDto getCookingMagazineClosest();

    boolean deleteBookById(Long id);
    BookDto findById(Long id);
    List<BookDto> findAllBooks();
    BookDto addBook(BookDto dto);

    NovelDto addNovel(NovelDto dto);
    MagazineDto addMagazine(MagazineDto dto);
    BookDto updateBook(BookDto dto);
    List<BookDto> getAllBooksByAuthorId(Long id);

    List<LibraryDto> getAllLibraries();
    LibraryDto getLibraryById(Long id);
    AuthorDto getAuthorById(Long id);
    CategoryDto getCategoryById(Long id);
}

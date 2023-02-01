package com.minotore.bookapp.services.impl;

import com.minotore.bookapp.dto.*;
import com.minotore.bookapp.repositories.*;
import com.minotore.bookapp.utils.BookType;
import com.minotore.bookapp.models.Book;
import com.minotore.bookapp.models.Magazine;
import com.minotore.bookapp.models.Novel;
import com.minotore.bookapp.services.LibraryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {
    private final NovelRepository novelRepository;
    private final MagazineRepository magazineRepository;
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public List<BookDto> getAllBooksbyLibraryName(String libName){


        return bookRepository.findByLibraryName(libName)
                .stream()
                .map(BookDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public MagazineDto addMagazine(MagazineDto dto) {
        Magazine magazine = MagazineDto.toEntity(dto);

        Magazine savedMagazine= magazineRepository.save(magazine);
        if(savedMagazine.getLibrary()!=null)
        savedMagazine.setLibrary(libraryRepository.findById(savedMagazine.getLibrary().getId()).get());
        if(savedMagazine.getAuthor()!=null)
        savedMagazine.setAuthor(authorRepository.findById(savedMagazine.getAuthor().getId()).get());
        return MagazineDto.fromEntity(savedMagazine);

    }
    @Override
    public BookDto addBook(BookDto dto){

          Book book=  bookRepository.save((BookDto.toEntity(dto)));
          if(book.getLibrary()!=null)
          book.setLibrary(libraryRepository.findById(book.getLibrary().getId()).get());
          if(book.getLibrary()!=null)
          book.setAuthor(authorRepository.findById(book.getAuthor().getId()).get());
        return BookDto.fromEntity(book);
    }
    @Override
    public NovelDto addNovel(NovelDto dto) {
        Novel novel = NovelDto.toEntity(dto);

        Novel savedNovel= novelRepository.save(novel);
        if(savedNovel.getLibrary()!= null)
        savedNovel.setLibrary(libraryRepository.findById(savedNovel.getLibrary().getId()).get());
        if(savedNovel.getAuthor()!=null)
        savedNovel.setAuthor(authorRepository.findById(savedNovel.getAuthor().getId()).get());
         return NovelDto.fromEntity(savedNovel);
    }
    @Override
    @Transactional
    public BookDto updateBook(BookDto dto){
        if(dto.getId()!=null){
            System.out.println("ID= "+dto.getId());
            Book book=bookRepository.findById(dto.getId()).orElseThrow(()->new EntityNotFoundException(dto.getId()+" not found"));

            return BookDto.fromEntity(bookRepository.save(BookDto.toEntity(dto)));
        }
        else{
            throw new EntityNotFoundException("No id was provided");
        }
    }

    @Override
    public List<BookDto> getAllBooksByAuthorId(Long id) {
        return bookRepository.findByAuthorId(id).stream().map(BookDto::fromEntity).collect(Collectors.toList());

    }

    @Override
    public List<LibraryDto> getAllLibraries() {
        return libraryRepository.findAll().stream().map(LibraryDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public LibraryDto getLibraryById(Long id) {
        return LibraryDto.fromEntity(libraryRepository.
                findById(id).orElseThrow(()->new EntityNotFoundException("Library with id="+id+" Not Found!")));
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        return AuthorDto.fromEntity(authorRepository
                .findById(id).orElseThrow(()->new EntityNotFoundException("Author with id="+id+" Not Found!")));
    }

    @Override
    public CategoryDto getCategoryById(Long id) {
        return CategoryDto.fromEntity(categoryRepository
                .findById(id).orElseThrow(()->new EntityNotFoundException("Category with id="+id+" Not Found!")));
    }

    @Override
    public boolean deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Book with id= "+id+" not found"));
        bookRepository.deleteById(id);
        return true;
    }
    @Override
    public BookDto findById(Long id) {
        return bookRepository.findById(id).map(BookDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Book was found with the provided ID"));
    }

    @Override
    public List<BookDto> findAllBooks() {
        return bookRepository.findAll().stream().map(BookDto::fromEntity).collect(Collectors.toList());
    }
    @Override
    public NovelDto getMostSoldNovelByAuthorId(Long id){
        return NovelDto.fromEntity(novelRepository.getMostSoldNovelByAuthorId(id));
    }
    @Override
    public MagazineDto getCookingMagazineClosest(){
        return MagazineDto.fromEntity(magazineRepository.getCookingMagazineClosest());
    }



}

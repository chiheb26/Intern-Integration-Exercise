package com.minotore.bookapp.Controllers;

import com.minotore.bookapp.dto.BookDto;
import com.minotore.bookapp.dto.LibraryDto;
import com.minotore.bookapp.dto.MagazineDto;
import com.minotore.bookapp.dto.NovelDto;
import com.minotore.bookapp.models.*;
import com.minotore.bookapp.repositories.BookRepository;
import com.minotore.bookapp.repositories.CategoryRepository;
import com.minotore.bookapp.services.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/books")
@CrossOrigin("*")
public class LibraryController {

    private final LibraryService libraryService;

    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        return libraryService.findById(id);
    }
    @GetMapping("")
    public List<BookDto> findAllBooks() {
        return libraryService.findAllBooks();
    }

    @GetMapping("/library/{libName}")
    public List<BookDto> getAllBooksByLibraryName(@PathVariable String libName){
        return libraryService.getAllBooksbyLibraryName(libName);
    }

    @GetMapping("/novel/most-sold/author/{id}")
    public NovelDto getMostSoldNovelByAuthorId(@PathVariable Long id){
        return libraryService.getMostSoldNovelByAuthorId(id);
    }
    @GetMapping("/magazine/closest/")
    public MagazineDto getCookingMagazineClosest(){
        return libraryService.getCookingMagazineClosest();
    }

    @PostMapping("/novel/add")
    public NovelDto addNovel(@RequestBody @Valid NovelDto dto){
        return libraryService.addNovel(dto);
    }
    @PostMapping("/magazine/add")
    public MagazineDto addMagazine(@RequestBody @Valid MagazineDto dto){
        return libraryService.addMagazine(dto);
    }
    @PostMapping("/book/add")
    public BookDto addBook(@RequestBody @Valid BookDto dto){
        return libraryService.addBook(dto);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBookById(@PathVariable Long id) {
        return libraryService.deleteBookById(id);
    }
    @PutMapping("/update/{id}")
    public BookDto updateBook(@PathVariable Long id,@RequestBody BookDto dto){
        return libraryService.updateBook(dto);
    }


    @GetMapping("/library")
    public List<LibraryDto> getAllLibraries(){
        return libraryService.getAllLibraries();
    }

    }

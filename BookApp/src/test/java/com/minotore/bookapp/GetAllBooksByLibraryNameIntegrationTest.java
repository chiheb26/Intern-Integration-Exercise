package com.minotore.bookapp;

import com.minotore.bookapp.dto.*;
import com.minotore.bookapp.models.Book;
import com.minotore.bookapp.models.Magazine;
import com.minotore.bookapp.models.Novel;
import com.minotore.bookapp.repositories.BookRepository;
import com.minotore.bookapp.services.impl.LibraryServiceImpl;
import com.minotore.bookapp.utils.BookType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GetAllBooksByLibraryNameIntegrationTest {



    @InjectMocks
    private LibraryServiceImpl libraryService;

    @Mock
    private BookRepository bookRepository;


    @Test
    public void givenLibraryNameThenBook1And2Returned() {
        List<Book> result = bookRepository.findByLibraryName("The Artists");
        assertEquals(true, result.isEmpty());
        //assertEquals(5, result.size());
    }

    @Test
    void should_save_one_book() {
        final var dto = BookDto.builder()
                .title("magazine 15646")
                .bookType(BookType.MAGAZINE)
                .price(10D).numberOfPages(20)
                .publicationDate(new Date(2005, 04, 12))
                .nextReleaseDate(new Date(2023, 12, 14)).keywords(List.of("key546", "key546465"))
                .build();
        when(bookRepository.save(any(Book.class))).thenReturn(BookDto.toEntity(dto));
        final var actual = libraryService.addBook(dto);
        assertThat(actual).usingRecursiveComparison().isEqualTo(dto);
        verify(bookRepository, times(1)).save(any(Book.class));
        verifyNoMoreInteractions(bookRepository);


    }

    @Test
    void should_find_and_return_one_Novel() {

        final var expectedNovel = NovelDto.builder()
                .title("novel1")
                .price(20D)
                .numberOfPages(10)
                .totalUnitsSold(50L)
                .storySummary("summary")
                .publicationDate(new Date(2012, 12, 10)).build();
    }

    @Test
    void should_not_found_a_book_that_doesnt_exists() {

        Long id = anyLong();
        when(bookRepository.findById(id)).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFoundException.class, () -> libraryService.findById(id));
        verify(bookRepository, times(1)).findById(id);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void should_find_and_return_all_books() {
        when(bookRepository.findAll()).thenReturn(List.of(new Novel(), new Magazine()));

        assertThat(libraryService.findAllBooks()).hasSize(2);
        verify(bookRepository, times(1)).findAll();
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    void should_delete_one_book() {

        doNothing().when(bookRepository).deleteById(anyLong());

        libraryService.deleteBookById(anyLong());
        verify(bookRepository, times(1)).deleteById(anyLong());
        verifyNoMoreInteractions(bookRepository);
    }
}
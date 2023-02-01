package com.minotore.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.minotore.bookapp.models.*;
import com.minotore.bookapp.utils.BookType;
import com.minotore.bookapp.utils.BookTypeSubset;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookDto {
    private Long id;
    @BookTypeSubset(anyOf = {BookType.NOVEL,BookType.MAGAZINE},message = "must be NOVEL or MAGAZINE")
    private BookType bookType;
    @NotBlank(message = "title must not be  empty")
    private String title;
    private Double price;
    private Long totalUnitsSold;
    private Date publicationDate;
    private Integer numberOfPages;
    private List<CategoryDto> categories;
    private AuthorDto author;
    private LibraryDto library;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Date nextReleaseDate;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> keywords;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String storySummary;


    public static Book toEntity(BookDto dto){
        if (dto==null)return null;
        if(dto.getBookType()==BookType.MAGAZINE) {
            Magazine magazine = new Magazine();
            if(dto.getId()!=null){
                magazine.setId(dto.getId());
            }
            if(dto.getTitle()!=null){
                magazine.setTitle(dto.getTitle());
            }
            //.........
            magazine.setPrice(dto.getPrice());
            magazine.setTotalUnitsSold(dto.getTotalUnitsSold());
            magazine.setPublicationDate(dto.getPublicationDate());
            magazine.setNumberOfPages(dto.getNumberOfPages());
            if(dto.getCategories()!=null && !dto.getCategories().isEmpty()) {
                magazine.setCategories(dto.getCategories().stream().map(CategoryDto::toEntity).collect(Collectors.toList()));
            }
            magazine.setAuthor(AuthorDto.toEntity(dto.getAuthor()));
            magazine.setLibrary(LibraryDto.toEntity(dto.getLibrary()));
            magazine.setNextReleaseDate(dto.getNextReleaseDate());
            magazine.setKeywords(dto.getKeywords());
            return magazine;
        }else if(dto.getBookType()==BookType.NOVEL)  {
            Novel novel= new Novel();
            novel.setId(dto.getId());
            novel.setTitle(dto.getTitle());
            novel.setPrice(dto.getPrice());
            novel.setTotalUnitsSold(dto.getTotalUnitsSold());
            novel.setPublicationDate(dto.getPublicationDate());
            novel.setNumberOfPages(dto.getNumberOfPages());
            if(dto.getCategories()!=null && !dto.getCategories().isEmpty()) {
                novel.setCategories(dto.getCategories().stream().map(CategoryDto::toEntity).collect(Collectors.toList()));
            }
            novel.setAuthor(AuthorDto.toEntity(dto.getAuthor()));
            novel.setLibrary(LibraryDto.toEntity(dto.getLibrary()));
            novel.setStorySummary(dto.getStorySummary());
            return novel;
        }
        return null;
    }

    public static BookDto fromEntity(Book entity){
        if (entity==null)return null;
        BookDto dto=new BookDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setTotalUnitsSold(entity.getTotalUnitsSold());
        dto.setPublicationDate(entity.getPublicationDate());
        dto.setNumberOfPages(entity.getNumberOfPages());
        if(entity.getCategories()!=null && !entity.getCategories().isEmpty()) {
            dto.setCategories(entity.getCategories().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()));
        }
        dto.setAuthor(AuthorDto.fromEntity(entity.getAuthor()));
        dto.setLibrary(LibraryDto.fromEntity(entity.getLibrary()));

        if(entity instanceof Magazine){
            Magazine magazine=(Magazine) entity;
            dto.setBookType(BookType.MAGAZINE);
            dto.setNextReleaseDate(magazine.getNextReleaseDate());
            dto.setKeywords(((Magazine) entity).getKeywords());
        }else if(entity instanceof Novel) {
            Novel novel=(Novel) entity;
            dto.setBookType(BookType.NOVEL);
            dto.setStorySummary(novel.getStorySummary());
        }
        return dto;
    }
}

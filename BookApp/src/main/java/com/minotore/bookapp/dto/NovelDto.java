package com.minotore.bookapp.dto;

import com.minotore.bookapp.models.Author;
import com.minotore.bookapp.models.Category;
import com.minotore.bookapp.models.Library;
import com.minotore.bookapp.models.Novel;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NovelDto {
    private Long id;
    @NotBlank(message = "title must not be empty")
    private String title;
    private Double price;
    private Long totalUnitsSold;
    private Date publicationDate;
    private Integer numberOfPages;
    private List<CategoryDto> categories;
    private AuthorDto author;
    private LibraryDto library;
    private String storySummary;


    public static Novel toEntity(NovelDto dto){
        if (dto==null)return null;
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

    public static NovelDto fromEntity(Novel novel){
        if (novel==null)return null;
            NovelDto dto=new NovelDto();
            dto.setId(novel.getId());
            dto.setTitle(novel.getTitle());
            dto.setPrice(novel.getPrice());
            dto.setTotalUnitsSold(novel.getTotalUnitsSold());
            dto.setPublicationDate(novel.getPublicationDate());
            dto.setNumberOfPages(novel.getNumberOfPages());
            dto.setCategories(novel.getCategories().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()));
            dto.setAuthor(AuthorDto.fromEntity(novel.getAuthor()));
            dto.setLibrary(LibraryDto.fromEntity(novel.getLibrary()));
            dto.setStorySummary(novel.getStorySummary());
            return dto;
    }

}

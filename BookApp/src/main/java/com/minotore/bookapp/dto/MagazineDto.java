package com.minotore.bookapp.dto;

import com.minotore.bookapp.models.*;
import lombok.*;

import javax.persistence.ElementCollection;
import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MagazineDto {


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
    private Date nextReleaseDate;
    private List<String> keywords;



    public static Magazine toEntity(MagazineDto dto){
        if (dto==null)return null;
        Magazine magazine= new Magazine();
        magazine.setId(dto.getId());
        magazine.setTitle(dto.getTitle());
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
        if(dto.getKeywords()!=null && !dto.getKeywords().isEmpty()) {
            magazine.setKeywords(dto.getKeywords());
        }
        return magazine;
    }

    public static MagazineDto fromEntity(Magazine magazine){
        if (magazine==null)return null;
        System.out.println(magazine);
        MagazineDto dto=new MagazineDto();
        dto.setId(magazine.getId());
        dto.setTitle(magazine.getTitle());
        dto.setPrice(magazine.getPrice());
        dto.setTotalUnitsSold(magazine.getTotalUnitsSold());
        dto.setPublicationDate(magazine.getPublicationDate());
        dto.setNumberOfPages(magazine.getNumberOfPages());
        dto.setCategories(magazine.getCategories().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()));
        dto.setAuthor(AuthorDto.fromEntity(magazine.getAuthor()));
        dto.setLibrary(LibraryDto.fromEntity(magazine.getLibrary()));
        dto.setNextReleaseDate(magazine.getNextReleaseDate());
        dto.setKeywords(magazine.getKeywords());
        return dto;
    }
}

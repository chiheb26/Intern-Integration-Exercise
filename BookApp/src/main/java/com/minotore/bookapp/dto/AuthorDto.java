package com.minotore.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minotore.bookapp.models.Author;
import com.minotore.bookapp.models.Book;
import com.minotore.bookapp.models.Novel;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorDto {
    private Long id;
    private String name;
    private Integer age;

    public static Author toEntity(AuthorDto dto) {
        if(dto==null)return null;
        return Author.builder().id(dto.getId()).name(dto.getName()).age(dto.getAge())
                //.books(dto.getBooks().stream().map(BookDto::toEntity)
                        //.collect(Collectors.toList()))
        .build();

    }
    public static AuthorDto fromEntity(Author author) {
        if (author==null)return null;
        return AuthorDto.builder().id(author.getId()).name(author.getName()).age(author.getAge())
                //.books(author.getBooks().stream().map(BookDto::fromEntity).collect(Collectors.toList()))
                .build();
    }
}

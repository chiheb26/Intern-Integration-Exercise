package com.minotore.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minotore.bookapp.models.Book;
import com.minotore.bookapp.models.Category;
import com.minotore.bookapp.models.Library;
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
public class LibraryDto {
    private Long id;
    private String name;
    private String address;

    public static LibraryDto fromEntity(Library library){
        if (library==null)return null;
        LibraryDto dto = new LibraryDto();
        dto.setId(library.getId());
        dto.setName(library.getName());
        dto.setAddress(library.getAddress());
        return dto;
    }
    public static Library toEntity(LibraryDto dto){
        if (dto==null)return null;
        Library library = new Library();
        library.setId(dto.getId());
        library.setName(dto.getName());
        library.setAddress(dto.getAddress());
        return library;
    }
}

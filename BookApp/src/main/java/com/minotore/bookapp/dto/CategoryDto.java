package com.minotore.bookapp.dto;

import com.minotore.bookapp.models.Category;
import com.minotore.bookapp.utils.BookType;
import com.minotore.bookapp.utils.BookTypeSubset;
import com.minotore.bookapp.utils.CategoryType;
import com.minotore.bookapp.utils.CategoryTypeSubset;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private Long id;
    @CategoryTypeSubset(anyOf = {CategoryType.CRIME,CategoryType.FASHION,CategoryType.COOKING,
    CategoryType.FICTION,CategoryType.HISTORCAL},message = "must be Crime,FASHION,COOKING,FICTION or HISTORCAL")
    private CategoryType categoryType;

    public static CategoryDto fromEntity(Category category){
        if (category==null)return null;
        return CategoryDto.builder().id(category.getId()).categoryType(category.getCategoryType()).build();
    }
    public static Category toEntity(CategoryDto dto){
        if (dto==null)return null;
        return Category.builder().id(dto.getId()).categoryType(dto.getCategoryType()).build();
    }
}

package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Category;
import com.minotore.bookapp.utils.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findByCategoryType(CategoryType categoryType);
}

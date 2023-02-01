package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Magazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MagazineRepository extends JpaRepository<Magazine,Long> {

   // @Query("select magazine,cat from Magazine magazine, join magazine.categories cat where magazine.nextReleaseDate=(select min (magazine.nextReleaseDate) from Magazine magazine) and (select category Category category where category.categoryType='COOKING') member of magazine.categories")
    @Query("select magazine from Magazine magazine where (select category from Category category where category.categoryType = 'COOKING') member of magazine.categories and (magazine.nextReleaseDate- CURRENT_DATE )=(select min (magazine.nextReleaseDate - CURRENT_DATE) from Magazine magazine)")
    Magazine getCookingMagazineClosest();


}

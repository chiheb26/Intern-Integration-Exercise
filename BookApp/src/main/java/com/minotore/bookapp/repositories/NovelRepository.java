package com.minotore.bookapp.repositories;

import com.minotore.bookapp.models.Novel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface NovelRepository extends JpaRepository<Novel,Long> {
    @Query("select novel from Novel novel where novel.author.id=:authId and novel.totalUnitsSold=(select max (novel.totalUnitsSold) from Novel novel where novel.author.id=:authId) ")
    Novel getMostSoldNovelByAuthorId(@Param("authId") Long authId);
}

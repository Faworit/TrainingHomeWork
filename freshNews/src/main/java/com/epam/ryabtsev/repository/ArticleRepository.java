package com.epam.ryabtsev.repository;

import com.epam.ryabtsev.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
    Article findByArticleId(int id);

    @Modifying
    @Transactional
    @Query("DELETE FROM Article WHERE artile_id = :id")
    void deleteByArticleId(@Param ("id") int id);
}

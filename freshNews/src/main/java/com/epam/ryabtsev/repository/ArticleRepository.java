package com.epam.ryabtsev.repository;

import com.epam.ryabtsev.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAll();
    Article findByArticleId(int id);
    @Transactional
    void deleteByArticleId(int id);
}

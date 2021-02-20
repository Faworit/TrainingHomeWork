package com.epam.ryabtsev.dao;

import com.epam.ryabtsev.entity.Article;

import java.util.List;

public interface ArticleDAO {
    void saveArticle(Article article);
    Article getArticle(int id);
    void deleteArticle(int id);
    void updateArticle(Article article);
    List<Article> getArticles();
}

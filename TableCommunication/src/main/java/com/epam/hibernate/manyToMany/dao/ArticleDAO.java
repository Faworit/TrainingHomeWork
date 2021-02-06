package com.epam.hibernate.manyToMany.dao;

import com.epam.hibernate.manyToMany.entity.Article;

public interface ArticleDAO {

    void saveArticle(Article article);
}

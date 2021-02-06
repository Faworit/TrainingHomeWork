package com.epam.hibernate.manyToMany.dao.impl;

import com.epam.hibernate.manyToMany.dao.ArticleDAO;
import com.epam.hibernate.manyToMany.entity.Article;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ArticleDAOImpl implements ArticleDAO {
    public void saveArticle(Article article) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(article);
        transaction.commit();
        session.close();
    }
}

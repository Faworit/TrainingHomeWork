package com.epam.ryabtsev.dao.impl;

import com.epam.ryabtsev.dao.ArticleDAO;
import com.epam.ryabtsev.entity.Article;
import com.epam.ryabtsev.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDAOImpl implements ArticleDAO {

    @Override
    public void saveArticle(Article article) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(article);
        transaction.commit();
        session.close();
    }

    @Override
    public Article getArticle(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Article article = session.get(Article.class, id);
        transaction.commit();
        session.close();
        return article;
    }

    @Override
    public void deleteArticle(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        String delete = "DELETE FROM Article WHERE id = " + id;
        session.createQuery(delete).executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public void updateArticle(Article article) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(article);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Article> getArticles() {
        List<Article> articles = (List<Article>) HibernateSessionFactory.getSessionFactory()
                .openSession().createQuery("FROM Article", Article.class).list();
        return articles;

    }
}

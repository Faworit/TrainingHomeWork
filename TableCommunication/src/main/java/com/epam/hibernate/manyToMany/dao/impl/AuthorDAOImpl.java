package com.epam.hibernate.manyToMany.dao.impl;

import com.epam.hibernate.manyToMany.dao.AuthorDAO;
import com.epam.hibernate.manyToMany.entity.Author;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AuthorDAOImpl implements AuthorDAO {

    public void saveAuthor(Author author) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        transaction.commit();
        session.close();
    }

    public void deleteAuthor(Author author) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(author);
        transaction.commit();
        session.close();
    }

    public Author getAuthor(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Author author = session.get(Author.class, id);
        transaction.commit();
        session.close();
        return author;
    }

    public void updateAuthor(Author author) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(author);
        transaction.commit();
        session.close();
    }
}

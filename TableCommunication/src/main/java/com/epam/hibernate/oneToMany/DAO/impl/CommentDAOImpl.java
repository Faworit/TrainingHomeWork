package com.epam.hibernate.oneToMany.DAO.impl;

import com.epam.hibernate.oneToMany.DAO.CommentDAO;
import com.epam.hibernate.oneToMany.entity.Comment;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CommentDAOImpl implements CommentDAO {
    public void saveComment(Comment comment) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(comment);
        transaction.commit();
        session.close();

    }

    public Comment getComment(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        transaction.commit();
        session.close();

        return comment;
    }

    public void deleteComment(Comment comment) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(comment);
        transaction.commit();
        session.close();
    }
}

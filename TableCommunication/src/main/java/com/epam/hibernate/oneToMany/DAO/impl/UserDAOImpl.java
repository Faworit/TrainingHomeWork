package com.epam.hibernate.oneToMany.DAO.impl;

import com.epam.hibernate.oneToMany.DAO.UserDAO;
import com.epam.hibernate.oneToMany.entity.User;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO {
    public void saveUser(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();

    }

    public User getUser(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        User user = session.get(User.class, id);
        transaction.commit();
        session.close();
        return user;
    }

    public void deleteUser(User user) {

    }
}

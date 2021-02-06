package com.epam.hibernate.oneToOne.dao.impl;

import com.epam.hibernate.oneToOne.Passport;
import com.epam.hibernate.oneToOne.dao.PassportDAO;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PassportDAOImpl implements PassportDAO {
    public Passport getPassport(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Passport passport = session.get(Passport.class, id);
        transaction.commit();
        session.close();
        return passport;
    }

    public void update(Passport passport) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(passport);
        transaction.commit();
        session.close();
    }

    public void delete(Passport passport) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(passport);
        transaction.commit();
        session.close();
    }
}

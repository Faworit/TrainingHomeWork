package com.epam.hibernate.oneToOneUD.dao.impl;

import com.epam.hibernate.oneToOneUD.Human;
import com.epam.hibernate.oneToOneUD.dao.HumanDAO;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HumanDAOImpl implements HumanDAO {
    public void save(Human human) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(human);
        transaction.commit();
        session.close();
    }

    public Human getHuman(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Human human = session.get(Human.class, id);
        transaction.commit();
        session.close();
        return human;
    }

    public void deleteHuman(Human human) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(human);
        transaction.commit();
        session.close();

    }

    public void updateHuman(Human human) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(human);
        transaction.commit();
        session.close();
    }
}

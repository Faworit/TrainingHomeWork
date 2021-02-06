package com.epam.hibernate.oneToOne.dao.impl;

import com.epam.hibernate.oneToOne.Person;
import com.epam.hibernate.oneToOne.dao.PersonDAO;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PersonDAOImpl implements PersonDAO {
    public void save(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public Person getPerson(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }

    public void delete(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(person);
        transaction.commit();
        session.close();
    }

    public void updatePerson(Person person) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }
}

package com.epam.hibernate.oneToOneUD.dao.impl;

import com.epam.hibernate.oneToOneUD.Credential;
import com.epam.hibernate.oneToOneUD.Human;
import com.epam.hibernate.oneToOneUD.dao.CredentialDAO;
import com.epam.hibernate.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CredentialDAOImpl implements CredentialDAO {

    public void saveCredential(Credential credential) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(credential);
        transaction.commit();
        session.close();
    }

    public void updateCredential(Credential credential) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(credential);
        transaction.commit();
        session.close();
    }

    public Credential getCredential(int id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession().getSession();
        Transaction transaction = session.beginTransaction();
        Credential credential = session.get(Credential.class, id);
        transaction.commit();
        session.close();
        return credential;
    }
}

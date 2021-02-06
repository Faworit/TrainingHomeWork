package com.epam.hibernate.util;

import com.epam.hibernate.manyToMany.entity.Article;
import com.epam.hibernate.manyToMany.entity.Author;
import com.epam.hibernate.oneToMany.entity.Comment;
import com.epam.hibernate.oneToMany.entity.User;
import com.epam.hibernate.oneToOne.Passport;
import com.epam.hibernate.oneToOne.Person;
import com.epam.hibernate.oneToOneUD.Credential;
import com.epam.hibernate.oneToOneUD.Human;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactory() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Passport.class);
            configuration.addAnnotatedClass(Human.class);
            configuration.addAnnotatedClass(Credential.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Comment.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Article.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());
        }

        return sessionFactory;
    }
}

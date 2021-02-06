package com.epam.hibernate.oneToOne.dao;

import com.epam.hibernate.oneToOne.Passport;
import com.epam.hibernate.oneToOne.Person;

public interface PassportDAO {
    Passport getPassport(int id);
    void update(Passport passport);
    void delete(Passport passport);
}

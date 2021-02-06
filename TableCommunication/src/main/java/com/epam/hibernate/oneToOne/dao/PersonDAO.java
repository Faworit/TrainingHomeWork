package com.epam.hibernate.oneToOne.dao;

import com.epam.hibernate.oneToOne.Person;

public interface PersonDAO {
    void save(Person person);
    Person getPerson(int id);
    void delete(Person person);
    void updatePerson(Person person);

}

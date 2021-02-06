package com.epam.hibernate.oneToOne;

import com.epam.hibernate.oneToOne.dao.PassportDAO;
import com.epam.hibernate.oneToOne.dao.PersonDAO;
import com.epam.hibernate.oneToOne.dao.impl.PassportDAOImpl;
import com.epam.hibernate.oneToOne.dao.impl.PersonDAOImpl;

import java.sql.Timestamp;
import java.util.Date;

public class Start {

    private static PersonDAO personDAO = new PersonDAOImpl();
    private static PassportDAO passportDAO = new PassportDAOImpl();

    public static void main(String[] args) {
        //savePerson();
        //getPerson(71/*enter some id*/);
        //deletePerson();
        //getPassport(72);
        //deletePassport(20, 19);
    }

    private static void savePerson() {
        Date date = new Date();
        Timestamp validDate = new Timestamp(date.getTime()+86400000000L);
        Timestamp issueDate = new Timestamp(date.getTime()-86400000*20);

        Passport passport = new Passport(issueDate, validDate);
        Person person = new Person("Tom", "Shmith", passport);
        passport.setPerson(person);
        personDAO.save(person);
    }

    private static void getPerson(int id) {
        Person person = personDAO.getPerson(id);
        System.out.println(person);
    }

    private static void deletePerson(int id) {
        Person person = personDAO.getPerson(id);
        personDAO.delete(person);
    }

    private static Passport getPassport(int id) {
        Passport passport = passportDAO.getPassport(id);
        System.out.println(passport.getPerson().getName());

        return passport;
    }

    private static void deletePassport(int idPassport, int idPerson) {
        Person person = personDAO.getPerson(idPerson);
        person.setPassport(null);
        personDAO.updatePerson(person);
        Passport passport = new Passport();
        passport.setPassportId(idPassport);
        passportDAO.delete(passport);
    }
}

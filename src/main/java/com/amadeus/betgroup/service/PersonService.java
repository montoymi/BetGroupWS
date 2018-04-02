package com.amadeus.betgroup.service;

import com.amadeus.betgroup.dao.PersonDAO;
import com.amadeus.betgroup.model.Person;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

public class PersonService {
    private PersonDAO personDAO = new PersonDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void createPerson(Person person) {
        personDAO.createPerson(person);
    }

    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }
}


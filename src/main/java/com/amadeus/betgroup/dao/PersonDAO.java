package com.amadeus.betgroup.dao;

import com.amadeus.betgroup.model.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

// Clase de ejemplo.
public class PersonDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PersonDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createPerson(Person person) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Person.insert", person);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePerson(Person person) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Person.update", person);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Person getPersonById(int id) {
        Person person;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            person = session.selectOne("Person.selectById", id);
        } finally {
            session.close();
        }

        return person;
    }
}


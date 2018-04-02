package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Sport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SportDAO {
    private SqlSessionFactory sqlSessionFactory;

    public SportDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createSport(Sport sport) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Sport.insert", sport);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePerson(Sport sport) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Sport.update", sport);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Sport getSportById(int id) {
        Sport sport;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            sport = session.selectOne("Sport.selectById", id);
        } finally {
            session.close();
        }

        return sport;
    }
}

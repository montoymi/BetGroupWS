package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Sport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SportDAO {
    private SqlSessionFactory sqlSessionFactory;

    public SportDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createSport(Sport sport) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Sport.insertSport", sport);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePerson(Sport sport) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Sport.updateSport", sport);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Sport getSportById(int id) {
        Sport sport;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            sport = session.selectOne("Sport.selectSportById", id);
        } finally {
            session.close();
        }

        return sport;
    }

    public List<Sport> getAllSports() {
        List<Sport> sportList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            sportList = session.selectList("Sport.selectAllSports");
        } finally {
            session.close();
        }
        return sportList;
    }
}

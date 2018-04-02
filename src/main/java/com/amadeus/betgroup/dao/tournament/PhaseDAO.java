package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Phase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PhaseDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PhaseDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createPhase(Phase phase) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Phase.insert", phase);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePhase(Phase phase) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Phase.update", phase);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Phase getPhaseById(int id) {
        Phase phase;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            phase = session.selectOne("Phase.selectById", id);
        } finally {
            session.close();
        }

        return phase;
    }
}

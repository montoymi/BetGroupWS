package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Phase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PhaseDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PhaseDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createPhase(Phase phase) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Phase.insertPhase", phase);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updatePhase(Phase phase) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Phase.updatePhase", phase);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Phase getPhaseById(int phaseId) {
        Phase phase;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            phase = session.selectOne("Phase.selectPhaseById", phaseId);
        } finally {
            session.close();
        }
        return phase;
    }

    public List<Phase> getAllPhasesByTournamentId(int tournamentId) {
        List<Phase> phaseList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            phaseList = session.selectList("Phase.selectAllPhasesByTournamentId", tournamentId);
        } finally {
            session.close();
        }
        return phaseList;
    }
}

package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Tournament;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TournamentDAO {
    private SqlSessionFactory sqlSessionFactory;

    public TournamentDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createTournament(Tournament tournament) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Tournament.insertTournament", tournament);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateTournament(Tournament tournament) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Tournament.updateTournament", tournament);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Tournament getTournamentById(int id) {
        Tournament tournament;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            tournament = session.selectOne("Tournament.selectTournamentById", id);
        } finally {
            session.close();
        }
        return tournament;
    }

    public List<Tournament> getAllTournaments() {
        List<Tournament> tournamentList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            tournamentList = session.selectList("Tournament.selectAllTournaments");
        } finally {
            session.close();
        }
        return tournamentList;
    }

}

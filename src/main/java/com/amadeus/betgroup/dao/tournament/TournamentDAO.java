package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Tournament;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TournamentDAO {
    private SqlSessionFactory sqlSessionFactory;

    public TournamentDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createTournament(Tournament tournament) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("tournament.Tournament.insert", tournament);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateTournament(Tournament tournament) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("tournament.Tournament.update", tournament);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Tournament getTournamentById(int id) {
        Tournament tournament;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            tournament = session.selectOne("tournament.Tournament.selectById", id);
        } finally {
            session.close();
        }

        return tournament;
    }

}

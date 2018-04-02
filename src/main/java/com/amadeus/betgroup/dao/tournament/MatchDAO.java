package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Match;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MatchDAO {
    private SqlSessionFactory sqlSessionFactory;

    public MatchDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Match getAllMatchInfoByMatchId(int id){
        Match match;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            match = session.selectOne("Match.getAllMatchInfoByMatchId", id);
        } finally {
            session.close();
        }
        return match;
    }


    public void createMatch(Match match) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Match.insert", match);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateMatch(Match match) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Tournament.update", match);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Match getMatchById(int id) {
        Match match;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            match = session.selectOne("Match.selectById", id);
        } finally {
            session.close();
        }

        return match;
    }
}

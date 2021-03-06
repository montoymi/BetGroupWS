package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.tournament.Match;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchDAO {
    private SqlSessionFactory sqlSessionFactory;

    public MatchDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Match> getMatchListWithBetsByUserId( int userId ){
        SqlSession session = sqlSessionFactory.openSession();
        List<Match> matchList;

        try {
            matchList = session.selectList("Match.getMatchListWithBetsByUserId", userId );
        } finally {
            session.close();
        }
        return matchList;
    }

    public Match getFullMatchInfoByMatchId(int matchId){
        Match match;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            match = session.selectOne("Match.selectFullMatchInfoByMatchId", matchId);
        } finally {
            session.close();
        }
        return match;
    }

    public void createMatch(Match match) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Match.insertMatch", match);
            session.commit();
        } finally {
            session.close();
        }
    }

	public void updateMatchStatus(Match match) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			session.update("Match.updateMatchStatus", match);
			session.commit();
		} finally {
			session.close();
		}
	}

    public void updateMatch(Match match) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("Match.updateMatch", match);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Match getMatchById(int matchId) {
        Match match;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            match = session.selectOne("Match.selectMatchById", matchId);
        } finally {
            session.close();
        }
        return match;
    }

    public void updateMatchResult(Match match){
        SqlSession session = sqlSessionFactory.openSession();
		String mensaje = "";

        try {
            Map<String, Object> map = new HashMap<>();
			map.put("match", match);
			map.put("mensaje", mensaje);

            session.selectOne("Match.updateMatchResult", map );
			mensaje = (String)map.get("mensaje");
            session.commit();

        }finally {
            session.close();
        }
    }

    public List<Match> getAllMatchesByGroupId( int groupId ){
        SqlSession session = sqlSessionFactory.openSession();
        List<Match> matchList;
        try{
            matchList = session.selectList("Match.selectAllMatchesByGroupId", groupId);
        } finally {
            session.close();
        }
        return matchList;
    }


	public List<Match> getMatchListDueStart() {
		SqlSession session = sqlSessionFactory.openSession();
		List<Match> matchList;
		try{
			matchList = session.selectList("Match.selectMatchListDueStart");
		} finally {
			session.close();
		}
		return matchList;
	}
}

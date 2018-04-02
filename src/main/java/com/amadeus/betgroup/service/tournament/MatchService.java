package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.MatchDAO;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;



public class MatchService {
    private MatchDAO matchDAO = new MatchDAO(MyBatisSqlSession.getSqlSessionFactory());


    public Match getAllMatchInfoByMatchId(int match_id) {
        Match match = matchDAO.getAllMatchInfoByMatchId(match_id);

        return match;
    }
}

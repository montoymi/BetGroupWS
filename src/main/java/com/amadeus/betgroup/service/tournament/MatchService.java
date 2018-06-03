package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.MatchDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.account.UserService;

import java.util.List;


public class MatchService {
    private MatchDAO matchDAO = new MatchDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<Match> getMatchListWithBetsByUserId( int userId ){
        List<Match> matchList = matchDAO.getMatchListWithBetsByUserId(userId);
        return matchList;
    }

    public Match getFullMatchInfoByMatchId(int match_id) {
        Match match = matchDAO.getFullMatchInfoByMatchId(match_id);

        return match;
    }

    public void updateMatchResult( int matchId, int scoreLocal, int scoreVisitor, String result, int userId ) {
        Match match = new Match();
        match.setMatchId( matchId );
        match.setScoreLocal( scoreLocal );
        match.setScoreVisitor( scoreVisitor );
        match.setResultMatch(result);
        match.setLastUpdatedBy( userId );
        try{
            matchDAO.updateMatchResult(match);
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public List<Match> getAllMatchesByGroupId(int groupId){
        List<Match> matchList = matchDAO.getAllMatchesByGroupId(groupId);
        return matchList;
    }

	public List<Match> getMatchListDueStart() {
		List<Match> matchList = matchDAO.getMatchListDueStart();
		return matchList;
	}

	public void closeMatchStatus(Integer matchId) {
		UserService userService = new UserService();
    	User user = userService.getUserByEmail("er.morales@gmail.com");
    	Match match = new Match();
		match.setMatchId( matchId );
		match.setEnabled_flag(0);
		match.setLastUpdatedBy( user.getUserId() );

		try{
			matchDAO.updateMatchStatus(match);
		}catch( Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}

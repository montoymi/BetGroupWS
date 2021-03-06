package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaBetDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.Date;
import java.util.List;

public class PollaBetService {
    private PollaBetDAO pollaBetDAO = new PollaBetDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void updateBetsByMatchIdUserId(List<PollaBet> pollaBetList) {
        try {
            pollaBetDAO.updateBetsByMatchIdUserId(pollaBetList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ApplicationException(e.getMessage());
        }
    }

    public List<PollaBet> getListBetsByMatchIdUserId(int userId, int matchId) {
        List<PollaBet> pollaBetList;
        try{
            pollaBetList = pollaBetDAO.getListBetsByMatchIdUserId( userId, matchId );
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }
        return pollaBetList;
    }

    public void updatePollaBetByBetId (PollaBet pollaBet) {
        try{
        	pollaBetDAO.updatePollaBet(pollaBet);
        }catch( PersistenceException e){
			throw new ApplicationException(e);
        }
    }

    public List<PollaBet> getListBetsByParticipantId( int participantId ) {
        List<PollaBet> pollaBetList;
        try{
            pollaBetList = pollaBetDAO.getListBetsByParticipantId( participantId );
        }catch( Exception b){
            b.printStackTrace();
            throw b;
        }
        return pollaBetList;
    }

}

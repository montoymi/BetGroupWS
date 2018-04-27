package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaBetDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class PollaBetService {
    private PollaBetDAO pollaBetDAO = new PollaBetDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void updatePollaBetByBetId (PollaBet pollaBet) {
        try{
            pollaBetDAO.updatePollaBet(pollaBet);
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<PollaBet> getListBetsByParticipantId( int participantId ) {
        List<PollaBet> pollaBetList;
        try{
            pollaBetList = pollaBetDAO.getListBetsByParticipantId( participantId );
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }
        return pollaBetList;
    }

}

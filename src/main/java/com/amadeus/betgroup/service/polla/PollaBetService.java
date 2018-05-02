package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaBetDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.Date;
import java.util.List;

public class PollaBetService {
    private PollaBetDAO pollaBetDAO = new PollaBetDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void updatePollaBetByBetId (PollaBet pollaBet) {
        try{
            if (  (new Date()).after( pollaBet.getPollaMatch().getMatch().getMatchDate() ) ){
                throw new ApplicationException("BET001");
                //Este pronostico no puede ser actualizado, dado que el evento ya empezo segun la fecha y hora actual definidos.
            } else{
                pollaBetDAO.updatePollaBet(pollaBet);
            }
        }catch( Exception e){
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

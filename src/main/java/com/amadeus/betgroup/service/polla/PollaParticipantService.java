package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaParticipantsDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.account.CreditService;

import java.util.List;

public class PollaParticipantService {
    private PollaParticipantsDAO pollaParticipantsDAO = new PollaParticipantsDAO(MyBatisSqlSession.getSqlSessionFactory());


    public PollaParticipant getPollaParticipantByPollaId(int polla_header_id, int user_id){
        try{

            PollaHeaderService pollaHeaderService = new PollaHeaderService();
            PollaHeader pollaHeaderBE = pollaHeaderService.getPollaById( polla_header_id );
            PollaParticipant pollaParticipant = new PollaParticipant();
            User participant = new User();
            participant.setUserId(user_id);
            pollaParticipant.setUser(participant);
            pollaParticipant.setPollaHeaderId(polla_header_id);
            pollaParticipant = pollaParticipantsDAO.getPollaParticipantByPollaId(pollaParticipant);

            pollaParticipant.setPollaHeader( pollaHeaderBE );

            return pollaParticipant;
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }

    }
    public List<PollaParticipant> getParticipantListByPollaId(int polla_id) {
        List<PollaParticipant> participantList = pollaParticipantsDAO.getParticipantListByPollaId(polla_id);

        return participantList;
    }

    public void inscribirUserInBetgroup( PollaParticipant pollaParticipant) throws ApplicationException {
        try{
            CreditService creditS = new CreditService();
            PollaHeaderService pollaHeaderService = new PollaHeaderService();

            Credit credit = creditS.getCreditSummaryByUserId(pollaParticipant.getUserId());
            PollaHeader pollaHeader = pollaHeaderService.getPollaById( pollaParticipant.getPollaHeaderId() );

            if( (pollaHeader.getCostFlag() == 1) && (credit.getTotalCreditos() < pollaHeader.getPollaCost()) ){
                throw new ApplicationException("E0005");
            } else {
                pollaParticipantsDAO.inscribirUserOnBetGroup(pollaParticipant);
            }
        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public List<PollaParticipant> getRankingPollaByHeaderId( int pollaHeaderId ){
        List<PollaParticipant> participantList = pollaParticipantsDAO.getRankingPollaByHeaderId(pollaHeaderId);
        return participantList;
    }
}

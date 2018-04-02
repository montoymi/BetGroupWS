package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaParticipantsDAO;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class PollaParticipantService {
    private PollaParticipantsDAO pollaParticipantsDAO = new PollaParticipantsDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<PollaParticipant> getParticipantsByPollaId(int polla_id) {
        List<PollaParticipant> participantList = pollaParticipantsDAO.getParticipantsByPollaId(polla_id);

        return participantList;
    }
}

package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.PhaseDAO;
import com.amadeus.betgroup.model.tournament.Phase;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class PhaseService {
    private PhaseDAO phaseDAO = new PhaseDAO(MyBatisSqlSession.getSqlSessionFactory());

    public List<Phase> getAllPhasesByTournamentId(int tournamentId){
        List<Phase> phaseList = phaseDAO.getAllPhasesByTournamentId(tournamentId);
        return phaseList;
    }

}

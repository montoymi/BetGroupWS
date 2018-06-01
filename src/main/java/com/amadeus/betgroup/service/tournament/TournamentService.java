package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.TournamentDAO;
import com.amadeus.betgroup.model.tournament.Tournament;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class TournamentService {
    private TournamentDAO tournamentDAO = new TournamentDAO(MyBatisSqlSession.getSqlSessionFactory());

    public List<Tournament> getAllTournaments(){
        List<Tournament> tournamentList = tournamentDAO.getAllTournaments();
        return tournamentList;
    }

	public void createTournament(Tournament tournament) {
		tournamentDAO.createTournament(tournament);
	}

	public void updateTournament(Tournament tournament) {
		tournamentDAO.updateTournament(tournament);
	}

	public Tournament getTournamentById(int id) {
		return tournamentDAO.getTournamentById(id);
	}
}

package com.amadeus.betgroup.service.tournament;

import com.amadeus.betgroup.dao.tournament.TeamDAO;
import com.amadeus.betgroup.model.tournament.Team;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class TeamService {
	private TeamDAO teamDAO = new TeamDAO(MyBatisSqlSession.getSqlSessionFactory());

	public void createTeam(Team team) {
		teamDAO.createTeam(team);
	}

	public void updateTeam(Team team) {
		teamDAO.updateTeam(team);
	}

	public Team getTeamById(int id) {
		return teamDAO.getTeamById(id);
	}

	public List<Team> getAllTeamsBySportId(int sportId){
		return teamDAO.getAllTeamsBySportId(sportId);
	}

}

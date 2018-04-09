package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Team;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TeamDAO {
    private SqlSessionFactory sqlSessionFactory;

    public TeamDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createTeam(Team team) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Team.insertTeam", team);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateTeam(Team team) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Team.updateTeam", team);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Team getTeamById(int teamId) {
        Team team;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            team = session.selectOne("Team.selectTeamById", teamId);
        } finally {
            session.close();
        }
        return team;
    }

    public List<Team> getAllTeamsBySportId(int sportId) {
        List<Team> teamList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            teamList = session.selectList("Team.selectAllTeamsBySportId", sportId);
        } finally {
            session.close();
        }
        return teamList;
    }
}

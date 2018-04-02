package com.amadeus.betgroup.dao.tournament;

import com.amadeus.betgroup.model.tournament.Team;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TeamDAO {
    private SqlSessionFactory sqlSessionFactory;

    public TeamDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void createTeam(Team team) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Team.insert", team);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateTeam(Team team) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("Team.update", team);
            session.commit();
        } finally {
            session.close();
        }
    }

    public Team getTeamById(int id) {
        Team team;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            team = session.selectOne("Team.selectById", id);
        } finally {
            session.close();
        }

        return team;
    }
}

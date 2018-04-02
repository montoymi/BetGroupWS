package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CreditDAO {
    private SqlSessionFactory sqlSessionFactory;

    public CreditDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<CreditDetail> getCreditTransactionByUserId( int userId){
        SqlSession session = sqlSessionFactory.openSession();
        List<CreditDetail> creditDetails;
        try {
            creditDetails =session.selectList("CreditDetails.getCreditTransactionsByUserId", userId);
            session.commit();

        } finally {
            session.close();
        }
        return creditDetails;
    }

    public Credit getTotalCreditosByUserID(Integer userId) {
        Credit creditSummary;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            creditSummary = session.selectOne("Credits.getTotalCreditosByUserID", userId);
        } finally {
            session.close();
        }

        return creditSummary;
    }


/*
    public void createCredit(Team team) {
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
*/
}

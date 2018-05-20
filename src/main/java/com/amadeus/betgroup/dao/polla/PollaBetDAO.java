package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaBet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollaBetDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaBetDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<PollaBet> getListBetsByMatchIdUserId(int userId, int matchId){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaBet> pollaBetList;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("matchId", matchId);
            pollaBetList = session.selectList("PollaBets.getListBetsByMatchIdUserId", map);
            session.commit();
        } finally {
            session.close();
        }

        return pollaBetList;
    }
    public void updatePollaBet(PollaBet pollaBet) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("PollaBets.updatePollaBet", pollaBet);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List<PollaBet> getListBetsByParticipantId(int pollaParticipantId){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaBet> pollaBetList;
        try {
            pollaBetList = session.selectList("PollaBets.getListBetsByParticipantId", pollaParticipantId);
            session.commit();
        } finally {
            session.close();
        }
        return pollaBetList;
    }

    public void updateBetsByMatchIdUserId(List<PollaBet> pollaBetList) {
        String overrideFlag = "Y"; //TODO: Revisar
        SqlSession session = sqlSessionFactory.openSession();
        try {
            for (PollaBet pollaBet : pollaBetList) {
                session.update("PollaBets.updatePollaBet", pollaBet);
            }
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}

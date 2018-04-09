package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.model.polla.PollaBet;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PollaBetDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaBetDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
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
}

package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.model.polla.PollaParticipant;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PollaParticipantsDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaParticipantsDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<PollaParticipant> getParticipantsByPollaId(int polla_header_id){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaParticipant> pollaParticipants;
        try {
            pollaParticipants =session.selectList("PollaParticipants.getParticipantsByPollaId", polla_header_id);
            session.commit();

        } finally {
            session.close();
        }
        return pollaParticipants;
    }


}

package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollaParticipantsDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaParticipantsDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    public PollaParticipant getPollaParticipantByPollaId(PollaParticipant pollaParticipant){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            pollaParticipant =session.selectOne("PollaParticipants.getPollaParticipantByPollaId", pollaParticipant);
            session.commit();

        } finally {
            session.close();
        }
        return pollaParticipant;
    }


    public List<PollaParticipant> getParticipantListByPollaId(int polla_header_id){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaParticipant> pollaParticipants;
        try {
            pollaParticipants =session.selectList("PollaParticipants.getParticipantListByPollaId", polla_header_id);
            session.commit();

        } finally {
            session.close();
        }
        return pollaParticipants;
    }

    public void inscribirUserOnBetGroup(PollaParticipant pollaParticipant){
        SqlSession session = sqlSessionFactory.openSession();
        String mensaje = "";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("pollaParticipant", pollaParticipant);
            map.put("mensaje", mensaje);

            session.selectOne("PollaParticipants.inscribirUserOnBetGroup", map );
            mensaje = (String)map.get("mensaje");

            session.commit();
            if( !mensaje.contentEquals("")){
                throw new ApplicationException(mensaje);
            }
        } finally {
            session.close();
        }

    }


}

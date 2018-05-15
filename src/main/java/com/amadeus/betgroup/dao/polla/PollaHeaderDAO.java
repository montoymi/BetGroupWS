package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaHeader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PollaHeaderDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaHeaderDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<PollaHeader> getMisPollasByUserId(int userId){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaHeader> pollaHeaders;
        try {
            pollaHeaders =session.selectList("PollaHeaders.getMisPollasByUserId", userId);
            session.commit();

        } finally {
            session.close();
        }
        return pollaHeaders;
    }

    public List<PollaHeader> getPollasDisponiblesByUserId(int userId){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaHeader> pollaHeaders;
        try {
            pollaHeaders =session.selectList("PollaHeaders.getPollasDisponiblesByUserId", userId);
            session.commit();

        } finally {
            session.close();
        }
        return pollaHeaders;
    }

    public void crearPolla(PollaHeader pollaHeader){
        SqlSession session = sqlSessionFactory.openSession();
        String mensaje = "";
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("pollaHeader", pollaHeader);
            map.put("mensaje", mensaje);

            session.selectOne("PollaHeaders.createBetGroup", map );
            mensaje = (String)map.get("mensaje");

            session.commit();

            if( !mensaje.contentEquals("")){
                throw new ApplicationException(mensaje);
            }
        }finally {
            session.close();
        }

    }

    public PollaHeader getPollaById(int id){
        SqlSession session = sqlSessionFactory.openSession();
        PollaHeader pollaHeader;
        try {
            pollaHeader = session.selectOne("PollaHeaders.getPollaById", id);
            session.commit();

        } finally {
            session.close();
        }
        return pollaHeader;
    }

    public boolean validatePollaPassword(PollaHeader pollaHeader){
        SqlSession session = sqlSessionFactory.openSession();

        int count;

        try {
            count = session.selectOne("PollaHeaders.validatePollaPassword", pollaHeader);
            session.commit();
        } finally {
            session.close();
        }

        return count == 1;
    }

    public String getPollaGameRules(PollaHeader pollaHeader, String lang) {
        SqlSession session = sqlSessionFactory.openSession();
        String gameRules;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("pollaHeader", pollaHeader);
            map.put("lang", lang);
            gameRules = session.selectOne("PollaHeaders.getPollaGameRules", map);
            session.commit();

        } finally {
            session.close();
        }
        return gameRules;
    }
}

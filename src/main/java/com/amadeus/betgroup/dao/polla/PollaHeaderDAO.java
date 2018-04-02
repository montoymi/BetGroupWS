package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.model.account.CreditDetail;
import com.amadeus.betgroup.model.polla.PollaHeader;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

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

}

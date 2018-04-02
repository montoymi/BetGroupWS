package com.amadeus.betgroup.dao.polla;

import com.amadeus.betgroup.model.polla.PollaMatch;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PollaMatchDAO {
    private SqlSessionFactory sqlSessionFactory;

    public PollaMatchDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<PollaMatch> getPollaMatchesByPollaId(int polla_header_id){
        SqlSession session = sqlSessionFactory.openSession();
        List<PollaMatch> pollaMatchList;
        try {
            pollaMatchList =session.selectList("PollaMatches.getPollaMatchesByPollaId", polla_header_id);
            session.commit();

        } finally {
            session.close();
        }
        return pollaMatchList;
    }
}

package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaMatchDAO;
import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class PollaMatchService {
    private PollaMatchDAO pollaMatchDAOa = new PollaMatchDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<PollaMatch> getPollaMatchesByPollaId(int polla_id) {
        List<PollaMatch> pollaMatchList = pollaMatchDAOa.getPollaMatchesByPollaId(polla_id);

        return pollaMatchList;
    }
}

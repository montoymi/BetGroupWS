package com.amadeus.betgroup.dao.config;

import com.amadeus.betgroup.model.config.ParamValue;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ParamValueDAO {
    private SqlSessionFactory sqlSessionFactory;

    public ParamValueDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public ParamValue selectParamValueByParamCode( ParamValue paramValue){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            paramValue = session.selectOne("ParamValues.selectParamValueByParamCode", paramValue);
            session.commit();
        } finally {
            session.close();
        }

        return paramValue;

    }


}

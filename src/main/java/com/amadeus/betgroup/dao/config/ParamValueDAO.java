package com.amadeus.betgroup.dao.config;

import com.amadeus.betgroup.model.config.ParamValue;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ParamValueDAO {
    private SqlSessionFactory sqlSessionFactory;

    public ParamValueDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public ParamValue selectOneParamValue( ParamValue paramValue){
        SqlSession session = sqlSessionFactory.openSession();

        try {
            paramValue = session.selectOne("ParamValues.selectParamValueByParamCode", paramValue);
            session.commit();
        } finally {
            session.close();
        }

        return paramValue;

    }

    public List<ParamValue> selectListParamValue(ParamValue paramValue){
        SqlSession session = sqlSessionFactory.openSession();
        List<ParamValue> paramValueList;
        try {
            paramValueList = session.selectList("ParamValues.selectListParamValueByParamCode", paramValue);
            session.commit();
        } finally {
            session.close();
        }

        return paramValueList;

    }

}

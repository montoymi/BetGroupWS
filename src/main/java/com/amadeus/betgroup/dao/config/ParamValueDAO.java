package com.amadeus.betgroup.dao.config;

import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.model.config.SlideIonic;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<ParamValue> selectInitSlideIonicList(String lang) {
        SqlSession session = sqlSessionFactory.openSession();
        List<ParamValue> paramValueList;
        try {
            paramValueList = session.selectList("ParamValues.selectSlideListInicio", lang);
            session.commit();
        } finally {
            session.close();
        }
        return paramValueList;

    }

	public ParamValue getWelcomeMessage(String username, String lang) {
		SqlSession session = sqlSessionFactory.openSession();
		ParamValue paramValue = new ParamValue();
		try {
			Map<String, Object> map = new HashMap<>();
			map.put("username", username);
			map.put("lang", lang);

			paramValue = session.selectOne("ParamValues.selectUserWelcomeMessage", map);
			session.commit();
		} finally {
			session.close();
		}
		return paramValue;
    }
}

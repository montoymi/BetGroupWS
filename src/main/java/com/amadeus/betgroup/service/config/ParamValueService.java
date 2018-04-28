package com.amadeus.betgroup.service.config;

import com.amadeus.betgroup.dao.config.ParamValueDAO;
import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class ParamValueService {
    private ParamValueDAO paramValueDAO = new ParamValueDAO(MyBatisSqlSession.getSqlSessionFactory());

    public ParamValue getParamValue(ParamValue paramValue) {
        return paramValueDAO.selectOneParamValue(paramValue);
    }

    public List<ParamValue> getParamValueList(ParamValue paramValue) {
        return paramValueDAO.selectListParamValue(paramValue);
    }
}

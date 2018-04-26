package com.amadeus.betgroup.service.config;

import com.amadeus.betgroup.dao.config.ParamValueDAO;
import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

public class ParamValueService {
    private ParamValueDAO paramValueDAO = new ParamValueDAO(MyBatisSqlSession.getSqlSessionFactory());

    public ParamValue getParaValueById(ParamValue paramValue) {
        return paramValueDAO.selectParamValueByParamCode(paramValue);
    }
}

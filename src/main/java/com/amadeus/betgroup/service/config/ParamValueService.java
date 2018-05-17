package com.amadeus.betgroup.service.config;

import com.amadeus.betgroup.dao.config.ParamValueDAO;
import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.model.config.SlideIonic;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.ArrayList;
import java.util.List;

public class   ParamValueService {
    private ParamValueDAO paramValueDAO = new ParamValueDAO(MyBatisSqlSession.getSqlSessionFactory());

    public ParamValue getParamValue(ParamValue paramValue) {
        return paramValueDAO.selectOneParamValue(paramValue);
    }

    public List<ParamValue> getParamValueList(ParamValue paramValue) {
        return paramValueDAO.selectListParamValue(paramValue);
    }

    public List<SlideIonic> getInitSlideIonicList(String lang) {
        List<ParamValue> paramValueList = paramValueDAO.selectInitSlideIonicList(lang);
        List<SlideIonic> slideIonicList = new ArrayList();

        for (int i = 0; i < paramValueList.size(); i++) {
            ParamValue paramValue = paramValueList.get(i);
            SlideIonic slide = new SlideIonic();

            slide.setNumSlide( paramValue.getParamCode() );
            slide.setTitle( paramValue.getParamValueString1());
            slide.setDescription(paramValue.getParamValueString2());
            slide.setImage( paramValue.getParamValueString3());
            slideIonicList.add(slide);
        }

        return slideIonicList;
    }

    public String getCondTerms(String lang){

    	ParamValue paramValue = new ParamValue();

    	paramValue = getParamValue(paramValue);

		String condTerm;

		return paramValue.getParamValueString1();
	}
}

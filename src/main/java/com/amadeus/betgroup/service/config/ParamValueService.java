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
        //usualmente este parametro contendra ya los criterios necesarios que hacen unicos a este registro.
		//Las llaves a usar son appcode, param type, para code, param language
    	return paramValueDAO.selectOneParamValue(paramValue);
    }

    public List<ParamValue> getParamValueList(ParamValue paramValue) {
        return paramValueDAO.selectListParamValue(paramValue);
    }

    public List<SlideIonic> getInitSlideIonicList(String lang) {
        List<ParamValue> paramValueList = paramValueDAO.selectInitSlideIonicList(lang);
        List<SlideIonic> slideIonicList = new ArrayList<>();

        for (ParamValue paramValue : paramValueList) {
            SlideIonic slide = new SlideIonic();

            slide.setNumSlide(paramValue.getParamCode());
            slide.setTitle(paramValue.getParamValueString1());
            slide.setDescription(paramValue.getParamValueString2());
            slide.setImage(paramValue.getParamValueString3());
            slideIonicList.add(slide);
        }

        return slideIonicList;
    }


	public ParamValue getInviteMessage( String senderEmail, String invitedEmail, int pollaHeaderId, String lang){
		ParamValue paramValue;
		paramValue = paramValueDAO.getInvitationMessage( senderEmail, invitedEmail, pollaHeaderId,lang);
		return paramValue;
	}

	public ParamValue getWelcomeMessage(String username, String lang){

		ParamValue paramValue = new ParamValue();
		paramValue.setParamLanguage(lang);
		paramValue = paramValueDAO.getWelcomeMessage(username, lang);

		return paramValue;
	}

    public String getCondTerms(String lang){

    	ParamValue paramValue = new ParamValue();
    	paramValue.setsAppCode("BETGROUPS");
    	paramValue.setsParamType("COND_TERM_PRIVA");
    	paramValue.setParamCode("1");
    	paramValue.setParamLanguage(lang);
    	paramValue = paramValueDAO.selectOneParamValue(paramValue);

		return paramValue.getParamValueString1();
	}


	public ParamValue getForgotPasswordMessage( int userId, String lang ) {
		ParamValue paramValue = new ParamValue();
		paramValue.setParamLanguage(lang);
		paramValue = paramValueDAO.getForgotPasswordMessage(userId, lang);

		return paramValue;
	}
}

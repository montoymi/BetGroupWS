package com.amadeus.betgroup.service.config;

import com.amadeus.betgroup.dao.config.ParamValueDAO;
import com.amadeus.betgroup.model.config.CardIonic;
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

	public List<CardIonic> getHomeCardList(int userId, String lang) {
		//List<ParamValue> paramValueList = paramValueDAO.selectHomeCardList(userId, lang);
		List<CardIonic> cardIonicList = new ArrayList<>();

		//for (ParamValue paramValue : paramValueList) {
			CardIonic card = new CardIonic();
//ó á é ú í ñ
			card.setCardType("NEWS");
			String content = "La copa del mundo está por empezar, y aquí en Kiniela Sports, ";
			content += "esperamos puedas vivir este mundial más de cerca, compitiendo  contra tus amigos partido a partido ";
			content += " con el objetivo de ganar el máximo premio! Buena suerte !";
			card.setContent1(content);
			card.setImage1("assets/img/tournam/card-mundial-rusia2018.jpg");
			card.setTitle("Bienvenido a Kiniela Sports");
			cardIonicList.add(card);

			CardIonic card2 = new CardIonic();

			card2.setCardType("NEWS");
			String content2 = "Bueeeenas! Si no te haz inscrito o creado un juego, que esperas! A la fecha se tiene ";
			content2 += "una kiniela que empieza el 14 de Junio y que cubrira todos los partidos del mundial. Invita a tus amigos y ";
			content2 += "haz que se inscriban! A mayor numero de participantes, mayor el pozo para el ganador!";
			card2.setContent1(content2);
			card2.setImage1("assets/img/tournam/card-mundial-rusia2018-3.jpg");
			card2.setTitle("Nuevos juegos Disponibles!");
			cardIonicList.add(card2);

		//}

		return cardIonicList;
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

	public List<ParamValue> getMatchForecastsMessage(int pollaHeaderId, int matchId) {
		List<ParamValue> paramValueList = paramValueDAO.getMatchForecastsMessage(pollaHeaderId, matchId);
		return paramValueList;
	}
}

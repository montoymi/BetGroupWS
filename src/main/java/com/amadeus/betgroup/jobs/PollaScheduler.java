package com.amadeus.betgroup.jobs;

import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.service.commons.EmailService;
import com.amadeus.betgroup.service.config.ParamValueService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;
import com.amadeus.betgroup.service.tournament.MatchService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;
import java.util.List;

public class PollaScheduler implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        System.out.println("Fecha y hora: " + new Date());

		MatchService matchService = new MatchService();
		PollaHeaderService pollaHeaderService = new PollaHeaderService();
		PollaParticipantService pollaParticipantService = new PollaParticipantService();
		ParamValueService paramValueService = new ParamValueService();

		List<Match> matchList = matchService.getMatchListDueStart();
		if ( matchList!= null ){
			for (int i = 0; i < matchList.size(); i++) {
				Match match = matchList.get(i);
				List<PollaHeader> pollaHeaderList = pollaHeaderService.getPollaHeaderListByMatchId(match.getMatchId());
				for (int j = 0; j < pollaHeaderList.size(); j++) {
					PollaHeader pollaHeader = pollaHeaderList.get(j);

					List<ParamValue> paramValueList = paramValueService.getMatchForecastsMessage( pollaHeader.getPollaId(), match.getMatchId() );

					for (int k = 0; k < paramValueList.size(); k++) {
						ParamValue paramValue = paramValueList.get(k);

						/*
						String lang = paramValue.getParamLanguage();
						String emailAll = "";
						List<PollaParticipant> participantList = pollaParticipantService.getParticipantListByPollaIdAndLang(pollaHeader.getPollaId(), lang);
						for (int l = 0; l < participantList.size(); l++) {
							PollaParticipant participant = participantList.get(l);
							emailAll += participant.getUser().getEmail();
							if ( l != (participantList.size()-1) )
								emailAll +=", ";
						}
						*/
						String subject = paramValue.getParamValueString1();
						String message = paramValue.getParamValueString2();
						String emailAll = paramValue.getParamValueString3();

						EmailService.sendBCCEmail( emailAll, subject, message);
						System.out.println("Email: " +  emailAll);
					}
					System.out.println("Polla: " + pollaHeader.getPollaId() );
				}
				System.out.println("Match: " +  match.getMatchId() );
				matchService.closeMatchStatus(match.getMatchId());
			}
		}
    }
}

package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.service.account.UserService;
import com.amadeus.betgroup.service.tournament.MatchService;

import java.util.List;
import java.util.Scanner;

public class MisPronosticosTest {
    public static void main(String args[]) throws Exception{

        System.out.println( "******  MIS PRONOSTICOS  **********");
        User userBE = BetGroupTest.signin();

        MatchService matchService = new MatchService();
        List<Match> matchList = matchService.getMatchListWithBetsByUserId(userBE.getUserId());
        System.out.println( "******  LISTA DE PARTIDOS Q ESTAN POR ARRANCAR **********");
        for (int i = 0; i < matchList.size(); i++) {
            Match match = matchList.get(i);
            System.out.println( "#" + (i+1) + " ID: " + match.getMatchId() + " - match code: " + match.getMatch_code() + " - Match Date: " + match.getMatchDate());
        }




        System.out.println( "******  MIS PRONOSTICOS  **********");
    }


}

package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.service.account.UserService;
import com.amadeus.betgroup.service.polla.PollaBetService;
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
        System.out.println( "Seleccione el #partido a registrar su pronostico:");
        String numItem = (new Scanner(System.in)).nextLine();
        Match match = matchList.get(Integer.parseInt(numItem)-1);

        // Una vez obtenido el partido que ha seleccionado el usuario, lo que debemos es llevarlo a una pantalla donde se
        //visualize el pronostico  a ingresar,  las pollas a las que pertenece y el score que se ingreso de haberse hecho.
        // Explicarle con un texto que el ingreso de este pronostico afectara a todos los juegos, o de repente darle la
        //opcion que el pronostico afecte solo a aquellos bets que estan vacios, o de repente a todos los bets.

        System.out.println( "Ud. selecciono el evento: ");
        System.out.println( match.getMatchId() + " - " + match.getMatchCode() + ": " + match.getLocalTeam().getTeamName()
                + " vs "+ match.getVisitorTeam().getTeamName() + " - Dia: " + match.getMatchDate());
        PollaBetService pollaBetService = new PollaBetService();
        List<PollaBet> pollaBetList = pollaBetService.getListBetsByMatchIdUserId(userBE.getUserId(), match.getMatchId());
        System.out.println( "Listado de Juegos, Pronosticos y Score a la fecha asociadas al match seleccionado: ");
        System.out.println( "Nombre Juego  |  Pronostico Local Score  |  Pronostico Visitor Score  |  Num Wildcard Left  |  Current Total Points");
        for (int i = 0; i < pollaBetList.size(); i++) {
            PollaBet pollaBet = pollaBetList.get(i);
            System.out.print( pollaBet.getPollaParticipant().getPollaHeader().getPollaName() + "  |  " + pollaBet.getLocalBetScore() + "  |  " + pollaBet.getVisitorBetScore());
            System.out.println( "  |  " + pollaBet.getPollaParticipant().getNumWildCardsLeft() + "  |  " + pollaBet.getPollaParticipant().getTotal());
        }



        PollaBet pollaBet = new PollaBet();
        PollaParticipant pollaParticipant = new PollaParticipant();
        pollaParticipant.setUserId( userBE.getUserId() );
        pollaBet.setPollaParticipant( pollaParticipant  );

        PollaMatch pollaMatch = new PollaMatch();
        pollaMatch.setMatchId( match.getMatchId() );
        pollaBet.setPollaMatch( pollaMatch );

        System.out.println("Marque L o V, para definir un ganador del encuentro o marque E si es empate: ");
        pollaBet.setResultBet( (new Scanner(System.in)).nextLine() );
        System.out.println("Ingrese el score Local");
        pollaBet.setLocalBetScore( Integer.parseInt((new Scanner(System.in)).nextLine()) );
        System.out.println("Ingrese el score visitante");
        pollaBet.setVisitorBetScore( Integer.parseInt((new Scanner(System.in)).nextLine()));

      //  System.out.println("Indique si desea proceder a actualizar solo los pronotiscos en blanco presionando (B)");
      //  System.out.println("De otra form indique que todos sus sean actualizados marque (T)");
      //  String modoPronostico = (new Scanner(System.in)).nextLine();

        System.out.println("Procediendo a registrar el pronostico en TODOS los diferentes juegos asociados ");
     //   pollaBetService.updateBetsByMatchIdUserId(pollaBet , "Y"); // Y refiere a que el flag override es V y chancara los datos que hay.
        System.out.println( "Pronostico actualizado satisfactoriamente");


        //PollaBetService pollaBetService = new PollaBetService();

       // pollaBetService.updatePollaBetByBetId(pollaBet);



        System.out.println( "******  MIS PRONOSTICOS  **********");
    }


}

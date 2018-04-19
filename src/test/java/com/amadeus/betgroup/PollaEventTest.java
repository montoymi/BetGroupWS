package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.service.polla.PollaBetService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;

import java.util.List;
import java.util.Scanner;

public class PollaEventTest {
    public static void main(String args[]) throws Exception{
        try{

            //Pantallla de Actualizar Pronostico:
            User userBE = BetGroupTest.signin();
            PollaHeaderService pollaHeaderS = new PollaHeaderService();
            List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());
            for (int i=0; i < pollaHeaderList.size(); i++ ){
                PollaHeader pollaHeader = pollaHeaderList.get(i);
                System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Entrada: " + pollaHeader.getPollaCost() + "  -  Acceso: " + pollaHeader.getAccessFlag());
            }

            if( pollaHeaderList.size() != 0 ) {
                Scanner in = new Scanner(System.in);
                System.out.println("Seleccione # Polla a ver Detalle: ");
                Integer pollaNum = Integer.parseInt(in.nextLine());
                PollaHeader pollaHeader = pollaHeaderList.get(pollaNum - 1);
                System.out.println("Listado de Eventos a pronosticar: ");
                PollaBetService pollaBetService = new PollaBetService();
                PollaParticipantService pollaParticipantS = new PollaParticipantService();
                PollaParticipant pollaParticipant = pollaParticipantS.getPollaParticipantByPollaId( pollaHeader.getPollaId(), userBE.getUserId());
                List<PollaBet> pollaBetList = pollaBetService.getListBetsByParticipantId(pollaParticipant.getPollaParticipantId());
                for (int i=0; i < pollaBetList.size(); i++ ) {
                    PollaBet pollaBet = pollaBetList.get(i);
                    System.out.println( (i+1) + " - " + pollaBet.getPollaMatch().getMatch().getMatchId() + " - " + pollaBet.getPollaMatch().getMatch().getMatchCode() + ": " + pollaBet.getPollaMatch().getMatch().getLocalTeam().getTeamName()
                            + " vs "+ pollaBet.getPollaMatch().getMatch().getVisitorTeam().getTeamName() + " - Dia: " + pollaBet.getPollaMatch().getMatch().getMatchDate());
                }

                System.out.print("Seleccione el # Polla Bet a pronosticar resultado: ");
                String sPollaBet = in.nextLine();
                Integer pollaBetId = Integer.parseInt(sPollaBet);
                PollaBet pollaBet = pollaBetList.get(pollaBetId-1);
                System.out.println( pollaBet.getPollaMatch().getMatch().getMatchId() + " - " + pollaBet.getPollaMatch().getMatch().getMatchCode() + ": " + pollaBet.getPollaMatch().getMatch().getLocalTeam().getTeamName()
                        + " vs "+ pollaBet.getPollaMatch().getMatch().getVisitorTeam().getTeamName() + " - Dia: " + pollaBet.getPollaMatch().getMatch().getMatchDate());

                System.out.println("Marque L o V, para definir un ganador del encuentro o marque E si es empate: ");
                String sResult = in.nextLine();
                System.out.println("Ingrese el score Local");
                String sLocalScore = in.nextLine();
                Integer localScore = Integer.parseInt(sLocalScore);
                System.out.println("Ingrese el score visitante");
                String sVisitorScore = in.nextLine();
                Integer visitorScore = Integer.parseInt(sVisitorScore );

                Integer flagComodin;
                if( pollaHeader.getModeWildcardFlag() != 0 ){
                    flagComodin = 0;
                }else{
                    System.out.println("Indique si dese asignar un comodin a su apuesta. Marque 1 para si o 0 para no :");
                    flagComodin = Integer.parseInt(in.nextLine());
                }
                pollaBet.setFlagWildcard(flagComodin);
                pollaBet.setLocalBetScore(localScore);
                pollaBet.setVisitorBetScore(visitorScore);
                pollaBet.setResultBet(sResult);
                pollaBet.setPollaParticipant( pollaParticipant );
                System.out.println("Procediendo a registrar el pronostico...");
                pollaBetService.updatePollaBetByBetId(pollaBet);
                System.out.println( "Pronostico actualizado satisfactoriamente");
            }
            else{
                System.out.println( "Usted no tiene ninguna polla inscrita.");
            }

        } catch( Exception e ){
            e.printStackTrace();
        }
    }
}

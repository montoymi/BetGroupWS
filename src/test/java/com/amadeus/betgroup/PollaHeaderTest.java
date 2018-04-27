package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;
import com.amadeus.betgroup.service.template.TemplateDetailService;
import com.amadeus.betgroup.service.template.TemplateHeaderService;

import java.util.List;
import java.util.Scanner;

public class PollaHeaderTest {

    public static void main ( String args[] ) throws Exception{
        boolean flagSalir = false;
        while ( !flagSalir ){
            System.out.println( "Seleccione una de las siguientes opciones: ");
            System.out.println( "1. Mis Juegos");
            System.out.println( "2. Juegos Disponibles");
            System.out.println( "3. Crear Juegos");
            System.out.println( "4. Mis Creditos");
            System.out.println( "5. Mis Amigos");
            System.out.println( "6. Mis Pronosticos");
            System.out.println( "7. Mi Perfil");
            System.out.println( "8. Templates");
            System.out.println( "9. Salir");

            Scanner in = new Scanner(System.in);
            String sOption = in.nextLine();
            Integer option = Integer.parseInt(sOption);

            switch ( sOption ){

                case "1": {
                    subOpcionMisJuegos();
                    break;
                }
                case "2": {
                   // subOpcionMisJuegos();
                    break;
                }
                case "8": {
                    subOpcionPlantillas();
                    break;
                }
                case "9": {
                    flagSalir = true;
                    System.out.println("Procediendo a cerrar la aplicacion de consola...");
                    break;
                }
            }





        }

    }

    private static void subOpcionPlantillas() {
        TemplateHeaderService templateHeaderService = new TemplateHeaderService();
        List<TemplateHeader> templateHeaderList = templateHeaderService.getAllActiveTemplateHeaderList();
        System.out.println( "Lista de plantillas habilitadas para creacion de Betgroups: ");
        for (int i=0; i < templateHeaderList.size(); i++ ){
            System.out.println( (i+1) + ": " + templateHeaderList.get(i).getTemplateName());
        }
        System.out.println("Seleccione # de Plantilla para crear BetGroup: ");
        Scanner in = new Scanner(System.in);
        String sTemHeaderId = in.nextLine();
        Integer tempHeaderId = Integer.parseInt(sTemHeaderId);
        TemplateHeader templateHeader = templateHeaderList.get(tempHeaderId-1);

        System.out.println( "Lista de eventos de Plantilla :" + templateHeader.getTemplateName());
        TemplateDetailService templateDetailService = new TemplateDetailService();
        List<TemplateDetail> templateDetailList = templateDetailService.getTemplateDetailsByTempHeader( templateHeader.getTemplateHeaderId());
        for (int i=0; i < templateDetailList.size(); i++ ) {
            TemplateDetail templateDetail = templateDetailList.get(i);
            System.out.println( templateDetail.getMatch().getMatchId() + " - " + templateDetail.getMatch().getMatchCode() + ": " + templateDetail.getMatch().getLocalTeam().getTeamName()
                    + " vs "+ templateDetail.getMatch().getVisitorTeam().getTeamName() + " - Dia: " + templateDetail.getMatch().getMatchDate());
        }

    }

    private static void subOpcionMisJuegos() {
        User userBE = BetGroupTest.signin();

        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());
        System.out.println( "Seleccione una de las siguientes opciones: ");
        for (int i=0; i < pollaHeaderList.size(); i++ ){
            PollaHeader pollaHeader = pollaHeaderList.get(i);
            System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Inscripcion: " + (( pollaHeader.getCostFlag() == 0 )? 0 : pollaHeader.getPollaCost()) + "  -  Acceso: " + ((pollaHeader.getAccessFlag()==0)? "Publico": "Privado"));
        }
        System.out.println("Seleccione # Polla a ver Detalle: ");
        Scanner in = new Scanner(System.in);
        String spollaNum = in.nextLine();
        Integer pollaNum = Integer.parseInt(spollaNum);
        PollaHeader pollaHeaderBE = pollaHeaderList.get(pollaNum-1);

        boolean flagSalir = false;
        while (!flagSalir){
            System.out.println("Indique una de las siguientes opciones: ");
            System.out.println("1.- Eventos");
            System.out.println("2.- Participantes");
            System.out.println("3.- Invitar");
            System.out.println("4.- Informacion");
            System.out.println("5.- Ranking");
            System.out.println("6.- Reglas");
            System.out.println("7.- Pronosticos");
            System.out.println("8.- Salir");
            String sOption = in.nextLine();
            Integer option = Integer.parseInt(sOption);

            switch ( sOption ){

                case "1": {
                    subOpcionEventos ( userBE, pollaHeaderBE );
                    break;
                }
                case "2": {
                    subOpcionParticipantes ( userBE, pollaHeaderBE );
                    break;
                }
                case "3": {
                    subOpcionInvitar( userBE, pollaHeaderBE );
                    break;
                }
                case "4": {
                    subOpcionInfo( userBE, pollaHeaderBE );
                    break;
                }
                case "5": {
                    subOpcionRanking( userBE, pollaHeaderBE );
                    break;
                }
                case "6": {
                    subOpcionReglas( userBE, pollaHeaderBE );
                    break;
                }
                case "7": {
                    subOpcionPronosticos( userBE, pollaHeaderBE );
                    break;
                }
                case "8": {
                    flagSalir = true;
                    break;
                }
                default:{
                    break;
                }
            }
        }

        System.out.println( "*********************");



    }

    private static void subOpcionReglas(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionRanking(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionPronosticos(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionInfo(User userBE, PollaHeader pollaHeaderBE) {
        PollaHeaderService pollaHeaderService = new PollaHeaderService();
        pollaHeaderBE = pollaHeaderService.getPollaById( pollaHeaderBE.getPollaId());

        pollaHeaderBE.getPollaName();
        pollaHeaderBE.getImage();
        pollaHeaderBE.getPollaCost();
        pollaHeaderBE.getNumWildcards();
        pollaHeaderBE.getAdmin().getUsername();
        pollaHeaderBE.getAccessFlag();
        pollaHeaderBE.getCostFlag();
        pollaHeaderBE.getPollaMatchList().size();
        pollaHeaderBE.getPollaParticipantList().size();
        pollaHeaderBE.getPollaEventList().size();
        pollaHeaderBE.getEnabled_flag(); // Definir estados de Polla
        // 0: Terminada 1: En Proceso 2: Abierta 3: Cancelada

        //pollaHeaderBE.getProjectStartDate();
        //pollaHeaderBE.getProjectEndDate();
        //pollaHeaderBE.getPozoAcumulado();

        PollaParticipantService pollaParticipantService = new PollaParticipantService();
        PollaParticipant pollaParticipant = pollaParticipantService.getPollaParticipantByPollaId(pollaHeaderBE.getPollaId(), userBE.getUserId() );

        pollaParticipant.getEarnings();
        pollaParticipant.getNumWildCards();
        pollaParticipant.getNumWildCardsLeft();
        pollaParticipant.getPosition();
        pollaParticipant.getTotal();
        pollaParticipant.getStatus();
        pollaParticipant.getInscriptionDate();
        pollaParticipant.getPollaParticipantId();
      //  pollaParticipant.get

    }

    private static void subOpcionInvitar(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionParticipantes(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionEventos(User userBE, PollaHeader pollaHeaderBE) {
    }
}

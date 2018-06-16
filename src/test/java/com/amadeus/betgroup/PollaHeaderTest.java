package com.amadeus.betgroup;

import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.config.SlideIonic;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.service.account.FriendService;
import com.amadeus.betgroup.service.admin.AdminService;
import com.amadeus.betgroup.service.polla.PollaBetService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;
import com.amadeus.betgroup.service.template.TemplateDetailService;
import com.amadeus.betgroup.service.template.TemplateHeaderService;

import java.util.List;
import java.util.Scanner;

public class PollaHeaderTest {

    public static void main ( String args[] ) throws Exception{
        boolean flagSalir = false;
        User userBE = BetGroupTest.signin();

        while ( !flagSalir ){
            System.out.println( "Seleccione una de las siguientes opciones: ");
            System.out.println( "0. Inicio");
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

                case "0": {
                    subOpcionInicio();
                    break;
                }case "1": {
                    subOpcionMisJuegos( userBE );
                    break;
                }
                case "2": {
                    subOpcionJuegosDisponibles( userBE );
                    break;
                }
                case "3": {
//                    subOpcionMisAmigos( userBE );
                    break;
                }
                case "5": {
  //                   subOpcionMisAmigos( userBE );
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

    private static void subOpcionJuegosDisponibles(User userBE){

    }

    private static void subOpcionInicio() {
        AdminService adminService = new AdminService();
        List<SlideIonic> slideIonicList = adminService.getSlidesforInicioPage("en");
        System.out.println( "Lista de Slides Ionic pagina Inicio");

        for (int i = 0; i < slideIonicList.size(); i++) {
            SlideIonic slide = slideIonicList.get(i);
            System.out.println( " slide # " + slide.getNumSlide());
            System.out.println( " title # " + slide.getTitle());
            System.out.println( " description # " + slide.getDescription());
            System.out.println( " image # " + slide.getImage());
        }
    }

    private static void subOpcionMisAmigos(User userBE) {
        FriendService friendS = new FriendService();
        boolean flagSalir = false;

        while (!flagSalir){
            List<Friend> friendList = friendS.getFriendListByUserId( userBE.getUserId() );
            System.out.println( "Imprimiendo lista de Amigos de " + userBE.getUsername() );
            for (int i=0; i < friendList.size(); i++ ){
                System.out.println( (i+1) + ": " + friendList.get(i).getAmigo().getUsername() + " | " + friendList.get(i).getAmigo().getFirstName() + " " + friendList.get(i).getAmigo().getLastName());
            }
            System.out.println( "Seleccione una opcion a realizar en la pantalla de Amigos: ");
            System.out.println( "1. Seguir Amigo ");
            System.out.println( "2. Desvincular Amigo");
            System.out.println( "3. Salir");

            Scanner in = new Scanner(System.in);
            String sOption = in.nextLine();
            Integer option = Integer.parseInt(sOption);

            switch( option ){
                case 1 : {
                    BetGroupTest.subOpcionSeguirAmigo( userBE );
                    break;
                }
                case 2: {
                    BetGroupTest.subOpcionDesvincularAmigo( userBE );
                    break;
                }
                case 3:{
                    flagSalir = true;
                    break;
                }
                default: {
                    System.out.println( "Opcion Incorrecta.");
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

    private static void subOpcionMisJuegos(User userBE) {

        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());
        System.out.println( "Seleccione una de las siguientes opciones: ");
        for (int i=0; i < pollaHeaderList.size(); i++ ){
            PollaHeader pollaHeader = pollaHeaderList.get(i);
            System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() +
                                " - Inscripcion: " + (( pollaHeader.getCostFlag() == 0 )? 0 : pollaHeader.getPollaCost()) +
                                " - Acceso: " + ((pollaHeader.getAccessFlag()==0)? "Publico": "Privado" + " - BetGroup Code: " + pollaHeader.getBetgroupCode()) +
                                " - Start Date: " + pollaHeader.getStartDate() + " -  End Date: " + pollaHeader.getEndDate()  +
                                " - Pozo Total: " + pollaHeader.getTotal_bet() + " - Num Participantes: " + pollaHeader.getNumParticipants() +
                                " - Admin: " + pollaHeader.getAdmin().getUsername() + " -  Status: " + pollaHeader.getEnabled_flag() +
                                " - Image: " + pollaHeader.getImage() + " - Cod Polla: " + pollaHeader.getBetgroupCode() );
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
		PollaParticipantService pollaParticipantService = new PollaParticipantService();
		List<PollaParticipant> pollaParticipantList = pollaParticipantService.getRankingPollaByHeaderId(pollaHeaderBE.getPollaId());

		System.out.println( "Mostrando Ranking de la polla: ");
		for (int i = 0; i < pollaParticipantList.size(); i++) {
			PollaParticipant pollaParticipant = pollaParticipantList.get(i);
			System.out.println( "#" + (i+1) + " - " + pollaParticipant.getUser().getUsername() + " - Posicion: " + pollaParticipant.getPosition());
		}
		System.out.println( "Seleccione el # participante a ver detalle de pronosticos hechos:");
		Integer numParticipant = Integer.parseInt((new Scanner(System.in)).nextLine());

		PollaParticipant pollaParticipant = pollaParticipantList.get(numParticipant);

		PollaBetService pollaBetService = new PollaBetService();
		List<PollaBet> pollaBetList = pollaBetService.getListBetsByParticipantId(pollaParticipant.getPollaParticipantId());

		for (int i = 0; i < pollaBetList.size(); i++) {
			PollaBet pollaBet = pollaBetList.get(i);
			pollaBet.getPollaMatch().getMatch().getMatch_code();

			pollaBet.getPollaMatch().getMatch().getScoreLocal();
			pollaBet.getPollaMatch().getMatch().getScoreVisitor();
			pollaBet.getPollaMatch().getMatch().getResultMatch();

			pollaBet.getLocalBetScore();
			pollaBet.getVisitorBetScore();
			pollaBet.getResultBet();
			pollaBet.getFlagWildcard();
			pollaBet.getPoints();
		}


	}

    private static void subOpcionPronosticos(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionInfo(User userBE, PollaHeader pollaHeaderBE) {


        PollaParticipantService pollaParticipantService = new PollaParticipantService();
        PollaParticipant pollaParticipant = pollaParticipantService.getPollaParticipantByPollaId(pollaHeaderBE.getPollaId(), userBE.getUserId() );
        pollaHeaderBE = pollaParticipant.getPollaHeader();

        pollaHeaderBE.getPollaName();
        pollaHeaderBE.getImage();
        pollaHeaderBE.getPollaCost();
        pollaHeaderBE.getNumWildcards();
        pollaHeaderBE.getAdmin().getUsername();
        pollaHeaderBE.getAccessFlag();
        pollaHeaderBE.getCostFlag();
        pollaHeaderBE.getNumParticipants();
        pollaHeaderBE.getNumEvents();
        pollaHeaderBE.getNumMatchs();

        pollaHeaderBE.getEnabled_flag(); // Definir estados de Polla
        // 0: Terminada 1: En Proceso 2: Abierta 3: Cancelada

        pollaHeaderBE.getStartDate();
        pollaHeaderBE.getEndDate();
        pollaHeaderBE.getTotal_bet();
        pollaHeaderBE.getBetgroupCode();




        pollaParticipant.getEarnings();
      //  pollaParticipant.getNumWildCards();
        pollaParticipant.getNumWildCardsLeft();
        pollaParticipant.getPosition();
        pollaParticipant.getTotal();
        pollaParticipant.getStatus();
        pollaParticipant.getInscriptionDate();
        pollaParticipant.getPollaParticipantId();

    }

    private static void subOpcionInvitar(User userBE, PollaHeader pollaHeaderBE) {

        System.out.println( "********INVITAR AMIGOS*******************");
        System.out.println( "Procediendo a invitar amigos al juego " + pollaHeaderBE.getPollaName());
        System.out.println( "Indique forma de invitar amigos al juego: ");
        System.out.println( "1. Por correo electronico ");
        System.out.println( "2. Por lista de amigos");
        Scanner in = new Scanner(System.in);
        String sInvOptAmigos = in.nextLine();
        Integer invOptAmigos = Integer.parseInt(sInvOptAmigos);

        switch( invOptAmigos ){
            case 1 : {
                subOpcionInvitarAmigoByEmail(userBE, pollaHeaderBE);
                break;
            }
            case 2: {
                subOpcionInvitarAmigoByUserId( userBE , pollaHeaderBE );
                break;
            }
            default: {
                System.out.println( "Opcion Incorrecta.");
                break;
            }
        }

    }

    private static void subOpcionInvitarAmigoByUserId(User userBE, PollaHeader pollaHeaderBE) {
        FriendService friendService = new FriendService();
        List<Friend> friendList = friendService.getFriendListByUserId( userBE.getUserId());
        System.out.println( "Lista de amigos asociados a su cuenta: ");
        for (int i = 0; i < friendList.size() ; i++) {
            Friend friend = friendList.get(i);
            System.out.println( "# " + (i+1) + friend.getAmigo().getUsername());
        }
        System.out.println( "Seleccione amigo a invitar:");
        Scanner in = new Scanner(System.in);
        String snumAmigo = in.nextLine();
        Integer numAmigo = Integer.parseInt(snumAmigo);

        Friend friend = friendList.get(numAmigo-1);

        friendService.inviteFriend( friend.getUser().getEmail(), friend.getAmigo().getEmail(), pollaHeaderBE.getPollaId(), "es");
        System.out.println( "Amigo invitado satisfactoriamente.");
    }

    private static void subOpcionInvitarAmigoByEmail(User userBE, PollaHeader pollaHeaderBE) {
        FriendService friendService = new FriendService();
        System.out.println( "Ingrese email de usuario a invitar: ");
        Scanner in = new Scanner(System.in);
        String email = in.nextLine();

        friendService.inviteFriend( userBE.getEmail(), email, pollaHeaderBE.getPollaId(), "es");

        System.out.println( "Amigo invitado satisfactoriamente.");

    }


    private static void subOpcionParticipantes(User userBE, PollaHeader pollaHeaderBE) {
    }

    private static void subOpcionEventos(User userBE, PollaHeader pollaHeaderBE) {
    }
}

package com.amadeus.betgroup;


import com.amadeus.betgroup.dao.polla.PollaHeaderDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.model.tournament.Group;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.model.tournament.Phase;
import com.amadeus.betgroup.model.tournament.Tournament;
import com.amadeus.betgroup.service.account.CreditService;
import com.amadeus.betgroup.service.account.FriendService;
import com.amadeus.betgroup.service.account.UserService;
import com.amadeus.betgroup.service.polla.PollaBetService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaMatchService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;
import com.amadeus.betgroup.service.template.TemplateDetailService;
import com.amadeus.betgroup.service.template.TemplateHeaderService;
import com.amadeus.betgroup.service.tournament.GroupService;
import com.amadeus.betgroup.service.tournament.MatchService;
import com.amadeus.betgroup.service.tournament.PhaseService;
import com.amadeus.betgroup.service.tournament.TournamentService;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BetGroupTest {
    public static void main(String args[]) throws Exception{
        try{

  //          opcionRegistrarUsuario();
 //           opcionActualizarPerfilUsuario();
  //          opcionMisPollas();
  //          opcionCrearJuego();
   //         opcionMisPollas();
   //         opcionJuegosDisponibles();
   //         opcionMisPollas();

            opcionAdminAdministrarEventos();

         //   historialCreditosByUser();
            /*
            System.out.println( "*********************");
            FriendService friendS = new FriendService();
            userBE = friendS.getFriendListByUserId( userBE.getUserId() );
            System.out.println( "Numero de amigos: " + userBE.getFriendList().size() );
            System.out.println( "Imprimiendo lista de Amigos de " + userBE.getUsername() );

            for (int i=0; i < userBE.getFriendList().size(); i++ ){
                System.out.println( (i+1) + ": " + userBE.getFriendList().get(i).getAmigo().getFirstName() + " " + userBE.getFriendList().get(i).getAmigo().getLastName());
            }

*/
           /*
            System.out.println( "Agregando un amigo con user name pedromc y user id 8,  al usuario chayno con userid 7");
            FriendService friendS = new FriendService();
            friendS.agregarAmigo(7,8);
            System.out.println( "Transaccion realizada correctamente.");
            */
        } catch( Exception e ){
            e.printStackTrace();
        }
    }

    private static void opcionAdminAdministrarEventos() {
        System.out.println( "******ADMINISTRAR EVENTOS***************");
        User userBE = signin();
        System.out.println( "Listado de Torneos del sistema: ");
        TournamentService tournamentService = new TournamentService();
        List<Tournament> torneoList = tournamentService.getAllTournaments();
        for (int i=0; i < torneoList.size(); i++ ){
            Tournament torneo = torneoList.get(i);
            System.out.println( (i+1) + " # - ID: " + torneo.getTournamentId() + " - Nombre: " + torneo.getTournamentName() );
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Seleccione # Torneo a ver Detalle: ");
        String sTorneoNum = in.nextLine();
        Integer torneoNum = Integer.parseInt(sTorneoNum);

        Tournament torneo = torneoList.get(torneoNum-1);
        System.out.println( "Listado de Fases asociadas al torneo: " + torneo.getTournamentName() + " con ID: " + torneo.getTournamentId());
        PhaseService phaseService = new PhaseService();
        List<Phase> phaseList = phaseService.getAllPhasesByTournamentId(torneo.getTournamentId());
        for (int i=0; i < phaseList.size(); i++ ){
            Phase phase= phaseList.get(i);
            System.out.println( (i+1) + " # - ID: " + phase.getPhaseId() + " - Nombre: " + phase.getPhaseName() );
        }
        System.out.println("Seleccione # Fase a ver Detalle: ");
        String sPhaseNum = in.nextLine();
        Integer phaseNum = Integer.parseInt(sPhaseNum);

        Phase phase = phaseList.get(phaseNum-1);
        System.out.println( "Listado de Grupos asociadas a la Fase: " + phase.getPhaseName() + " con ID: " + phase.getPhaseId());
        GroupService groupService = new GroupService();
        List<Group> groupList = groupService.getAllGroupsByPhaseId(phase.getPhaseId());
        for (int i=0; i < groupList.size(); i++ ){
            Group group = groupList.get(i);
            System.out.println( (i+1) + " # - ID: " + group.getGroupId() + " - Nombre: " + group.getGroupName() );
        }
        System.out.println("Seleccione # Grupo a ver Detalle: ");
        String sGrupoNum = in.nextLine();
        Integer grupoNum = Integer.parseInt(sGrupoNum);

        Group group = groupList.get( grupoNum-1);
        System.out.println( "Listado de Matches asociadas al Grupo: " + group.getGroupName() + " con ID: " + group.getGroupId());

        MatchService matchService = new MatchService();
        List<Match> matchList = matchService.getAllMatchesByGroupId(group.getGroupId());

        for (int i=0; i < matchList.size(); i++ ){
            Match match = matchList.get(i);
            System.out.println( (i+1) + " # - ID: " + match.getMatchId() + " - Match Code: " + match.getMatchCode() +
                                        " - Match: " + match.getLocalTeam().getTeamName() + " vs " + match.getVisitorTeam().getTeamName() +
                                        " - Match Date: " + match.getMatchDate() );
        }
        System.out.println("Seleccione # Partido actualizar resultado: ");
        String sMatchNum = in.nextLine();
        Integer matchNum = Integer.parseInt(sMatchNum);

        Match match = matchList.get(matchNum-1);
        match.setLastUpdatedBy( userBE.getUserId() );
        System.out.println( "ID: " + match.getMatchId() + " - Match Code: " + match.getMatchCode() +
                            " - Match: " + match.getLocalTeam().getTeamName() + " vs " + match.getVisitorTeam().getTeamName() +
                            " - Match Date: " + match.getMatchDate() );

        System.out.println("Marque L o V, para definir un ganador del encuentro o marque E si es empate: ");
        String sResult = in.nextLine();
        System.out.println("Ingrese el score Local");
        String sLocalScore = in.nextLine();
        Integer localScore = Integer.parseInt(sLocalScore);
        System.out.println("Ingrese el score visitante");
        String sVisitorScore = in.nextLine();
        Integer visitorScore = Integer.parseInt(sVisitorScore );

        System.out.println("Procediendo a actualizar el resultado del encuentro y actualizar puntaje y ranking en todas las pollas asociadas a ese enceuntro...");

        matchService.updateMatchResult( match.getMatchId(), localScore, visitorScore, sResult, match.getLastUpdatedBy());
        System.out.println(" Todo se ejecuto correctamente. ");

    }

    private static void subopcionVerDetallePolla(){

    }

    private static void opcionMisPollas(){
        System.out.println( "******MIS POLLAS***************");
        User userBE = signin();
        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());

        System.out.println( "Listado de Pollas Inscritas del usuario: " + userBE.getUsername());
        System.out.println( "Numero de pollas inscritas: " + pollaHeaderList.size());
        for (int i=0; i < pollaHeaderList.size(); i++ ){
            PollaHeader pollaHeader = pollaHeaderList.get(i);
            System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Entrada: " + pollaHeader.getPollaCost() + "  -  Acceso: " + pollaHeader.getAccessFlag());
        }
        System.out.println( "*********************");

        if( pollaHeaderList.size() != 0 ){
            Scanner in = new Scanner(System.in);
            System.out.println("Seleccione # Polla a ver Detalle: ");
            String spollaNum = in.nextLine();
            Integer pollaNum = Integer.parseInt(spollaNum);

            PollaHeader pollaHeader = pollaHeaderList.get(pollaNum-1);

            System.out.println("Detalle de Polla seleccionada");
            System.out.println("Nombre de Polla: " + pollaHeader.getPollaName());
            UserService userS = new UserService();
            User admin = userS.selectUserById(pollaHeader.getAdminId());
            System.out.println("Administrador: " + admin.getUsername());
            System.out.println("Fecha de inicio: " );
            PollaParticipantService pollaParticipantS = new PollaParticipantService();
            List<PollaParticipant> participantList = pollaParticipantS.getParticipantListByPollaId(pollaHeader.getPollaId());
            System.out.println("# Participantes: " + participantList.size());

            PollaMatchService pollaMatchS = new PollaMatchService();
            List<PollaMatch> pollaMatchList = pollaMatchS.getPollaMatchesByPollaId(pollaHeader.getPollaId());
            System.out.println("# Eventos: " + pollaMatchList.size());
            System.out.println("Estado: ");
            System.out.println("Puntos acumulados: ");

            System.out.println( "*********************");
            System.out.println("Sub Opcion: Listado de Eventos: ");
            for (int i=0; i < pollaMatchList.size(); i++ ) {
                PollaMatch pollaMatch = pollaMatchList.get(i);
                System.out.println( pollaMatch.getMatch().getMatchId() + " - " + pollaMatch.getMatch().getMatchCode() + ": " + pollaMatch.getMatch().getLocalTeam().getTeamName()
                        + " vs "+ pollaMatch.getMatch().getVisitorTeam().getTeamName() + " - Dia: " + pollaMatch.getMatch().getMatchDate());
            }

            System.out.println( "*********************");
            System.out.println("Sub Opcion: Ver Detalle de evento: ");

            System.out.print("Seleccione el id Match a visualizar detalle: ");
            String sMatchId = in.nextLine();
            Integer matchId = Integer.parseInt(sMatchId);
            MatchService matchS = new MatchService();
            Match match = matchS.getFullMatchInfoByMatchId(matchId);
            System.out.println( match.getGroup().getPhase().getTournament().getSport().getSportName());
            System.out.println( match.getGroup().getPhase().getTournament().getTournamentName());
            System.out.println( match.getGroup().getPhase().getPhaseName());
            System.out.println( match.getGroup().getGroupName());
            System.out.println( match.getMatchCode() +" - "+ match.getMatchDate());
            System.out.println( match.getLocalTeam().getTeamName() + " vs " + match.getVisitorTeam().getTeamName() );

            System.out.println( "*********************");
            System.out.println("Sub Opcion: Listado de Participantes: ");
            for (int i=0; i < participantList.size(); i++ ) {

                PollaParticipant participante = participantList.get(i);
                System.out.println( (i+1) + "#: " + participante.getUser().getEmail() + " - " + participante.getUser().getUsername() + " - " +
                        participante.getUser().getFirstName() + " " + participante.getUser().getLastName() );
            }

        //    System.out.println( "Seleccionar participante a seguir:");
         //   String sNumParticipante = in.nextLine();
         //   Integer participanteNum = Integer.parseInt(sNumParticipante );
         //   PollaParticipant participante = participantList.get(participanteNum-1);
          //  User userParticipante = userS.selectUserById(participante.getUserId());
       //     System.out.println( "Agregando usuario a lista de amigos: " + userParticipante.getUsername());

            System.out.println( "*********************");
            System.out.println( "actualizando pronosticos para usuario: " + userBE.getUsername());


            System.out.println("Listado de Eventos a pronosticar: ");
            PollaBetService pollaBetService = new PollaBetService();

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
            System.out.println("Procediendo a registrar el pronostico...");
            pollaBet.setLocalBetScore(localScore);
            pollaBet.setVisitorBetScore(visitorScore);
            pollaBet.setResultBet(sResult);
            pollaBet.setPollaParticipant( pollaParticipant );

            pollaBetService.updatePollaBetByBetId(pollaBet);
            System.out.println( "Pronostico actualizado satisfactoriamente");


        } else{
            System.out.println( "Usted no tiene ninguna polla inscrita.");
        }
    }

    private static void historialCreditosByUser(){
        User userBE = signin();
        CreditService creditS = new CreditService();
        Credit creditHistory = creditS.getCreditHistoryByUserId(userBE.getUserId());
        System.out.println( "*********************");
        System.out.println( "Resumen de creditos para : " + userBE.getUsername() );
        System.out.println( "Total Creditos en cuenta = " + creditHistory.getTotalCreditos());
        System.out.println( "*********************");

    }

    private static User signin(){
        System.out.println("*********LOGUEANDOSE AL SISTEMA*********************");

        Scanner in = new Scanner(System.in);
        String username;
        String password;

        UserService userS = new UserService();
        User userBE = new User();
        boolean flagAcces = false;

        while (!flagAcces) {
            System.out.print("Please enter user name : ");
            username = in.nextLine();
            System.out.print("Please enter password :");
            password = in.nextLine();
            userBE = userS.validateLogin(username,  password);
            if ( userBE == null ){
                System.out.println("Credenciales invalidas. Ingrese un usuario y password nuevamente: ");
            }else{
                flagAcces = true;
            }
        }
        System.out.println( "Informacion de usuario " + userBE.getUsername());
        System.out.println( "userid = " + userBE.getUserId());
        System.out.println( "Name = " + userBE.getFirstName());
        System.out.println( "Apellido = " + userBE.getLastName());
        System.out.println( "Fecha de Nacimiento = " + userBE.getDateOfBirthday());
        System.out.println( "Sexo = " + userBE.getSex());
        System.out.println( "email = " + userBE.getEmail());
        System.out.println( "Password = " + userBE.getPassword());
        System.out.println( "*********************");

        return userBE;
    }

    private static void opcionJuegosDisponibles() {
        System.out.println( "******POLLAS DISPONIBLES***************");
        User userBE = signin();
        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        List<PollaHeader> pollaHeaderList = pollaHeaderS.getPollasDisponiblesByUserId( userBE.getUserId());

        System.out.println( "Listado de Pollas Disponibles para usuario : " + userBE.getUsername());

        for (int i=0; i < pollaHeaderList.size(); i++ ){
            PollaHeader pollaHeader = pollaHeaderList.get(i);
            System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Entrada: " + pollaHeader.getPollaCost() + "  -  Acceso: " + pollaHeader.getAccessFlag());
        }
        Scanner in = new Scanner(System.in);
        System.out.print("Seleccione # Polla a inscribirse: ");
        String spollaNum = in.nextLine();
        Integer pollaNum = Integer.parseInt(spollaNum);

        PollaHeader pollaHeader = pollaHeaderList.get(pollaNum-1);

        boolean flagInscripCompleta =  false;
        boolean flagInscripCancel =  false;
        while (!flagInscripCompleta){
            if (pollaHeader.getAccessFlag() != 0 ){
                System.out.print("Esta polla es privada. Ingrese el password de la polla para proceder a la inscripcion: ");
                String pollaPass = in.nextLine();
                if (pollaPass.contentEquals("CANCEL") ){
                    flagInscripCompleta = true;
                    flagInscripCancel = true;
                } else if ( pollaPass.contentEquals( pollaHeader.getPassword())){
                    flagInscripCompleta = true;
                }else{
                    System.out.println("El password de la polla es incorrecto. Ingrese nuevamente el password o digite CANCEL para salir:");
                }
            }else{
                flagInscripCompleta = true;

            }
        }
        if ( flagInscripCompleta && !flagInscripCancel){
            PollaParticipant pollaParticipant = new PollaParticipant();
            pollaParticipant.setPollaHeaderId(pollaHeader.getPollaId());
            pollaParticipant.setUser(userBE);

            PollaParticipantService pollaParticipantService = new PollaParticipantService();
            pollaParticipantService.inscribirUserInBetgroup(pollaParticipant);
            System.out.println("El usuario " + userBE.getUsername() + " ha sido inscrito satisfactoriamente a la polla: " + pollaHeader.getPollaName());
        }



    }

    private static void opcionCrearJuego() throws Exception{
        System.out.println( "******CREAR POLLA***************");
        User userBE = signin();
        System.out.println( "*********************");
        System.out.println( "Procediendo a crear juego");
        System.out.println( "Lista de plantillas habilitadas para creacion de Betgroup: ");
        TemplateHeaderService tempHeaderS = new TemplateHeaderService();
        List<TemplateHeader> templateHeaderList = tempHeaderS.getAllTemplateHeaderList();
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
        List<TemplateDetail> templateDetailList = templateDetailService.getTemplateDetailsByTempHeader( templateHeader.getTemplateId());
        System.out.println( "# de partidos " + templateDetailList.size());
        System.out.println("Imprimiendo lista de eventos: ");
        for (int i=0; i < templateDetailList.size(); i++ ) {
            TemplateDetail templateDetail = templateDetailList.get(i);
            System.out.println( templateDetail.getMatch().getMatchId() + " - " + templateDetail.getMatch().getMatchCode() + ": " + templateDetail.getMatch().getLocalTeam().getTeamName()
                    + " vs "+ templateDetail.getMatch().getVisitorTeam().getTeamName() + " - Dia: " + templateDetail.getMatch().getMatchDate());
        }

        System.out.println("Configurando Betgroup Cabecera: ");
        PollaHeader pollaHeader = new PollaHeader();
        System.out.print("Ingrese nombre de Betgroup a crear: ");
        String nombreBetgroup = in.nextLine();
        pollaHeader.setPollaName(nombreBetgroup);
        System.out.print("Marque 1 si el Betgroup es privado, o 0 si el Betgroup sera publico: ");
        String sflagPrivado = in.nextLine(); // 1: Privado - 0: Publico
        Integer flagPrivado = Integer.parseInt(sflagPrivado);
        pollaHeader.setAccessFlag(flagPrivado);
        if( flagPrivado == 1  ){
            System.out.print("Indique el password del Betgroup a crear: ");
            String password = in.nextLine();
            pollaHeader.setPassword(password);
        }
        System.out.print("Marque 1 si el Betgroup tendra costo, o 0 si el Betgroup sera gratuito: ");
        String sFlagCosto = in.nextLine(); // 1: ConCosto - 0: SinCosto
        Integer flagCosto = Integer.parseInt(sFlagCosto);
        pollaHeader.setCostFlag(flagCosto);
        if( flagCosto == 1  ){
            System.out.print("Indique el costo de inscripcion del Betgroup a crear: ");
            String sCostoPolla = in.nextLine();
            Integer costoPolla = Integer.parseInt(sCostoPolla);
            pollaHeader.setPollaCost(costoPolla);
        }
        System.out.print("Administrador del Betgroup a crear: " + userBE.getUsername());
        pollaHeader.setAdminId( userBE.getUserId());
        pollaHeader.setTemplateHeaderId( templateHeader.getTemplateId() );

        PollaHeaderService pollaHeaderS = new PollaHeaderService();
        pollaHeaderS.crearPolla(pollaHeader);
        System.out.println("Polla creada satisfactoriamente.");
    }

    public static void opcionRegistrarUsuario(){
        String username = null;
        String password = null;
        String email = null;
        System.out.println( "******REGISTRAR USUARIO***************");
        System.out.println("Formulario de Registro de Usuario: ");
        Scanner in = new Scanner(System.in);
        UserService userService = new UserService();
        User userBE = new User();
        boolean flagRegistro = false;
        while( !flagRegistro ){
            try{
                System.out.print("Porfavor, ingrese su username: ");
                username = in.nextLine();
                userBE.setUsername( username );
                System.out.print("Porfavor, ingrese su email: ");
                email = in.nextLine();
                userBE.setEmail(email);

                boolean flagPassword = false;
                while (!flagPassword) {
                    System.out.print("Porfavor, ingrese el password de su cuenta: ");
                    password = in.nextLine();
                    System.out.print("Porfavor, confirme el password otra vuelta: ");
                    String password2 = in.nextLine();
                    if ( password.contentEquals(password2)){
                        flagPassword = true;
                        userBE.setPassword(password);
                    } else{
                        System.out.println("Los passwords no coinciden. Ingrese el nuevo password otra vuelta: ");
                    }
                }
                System.out.println("Procediendo a registrar al usuario en el sistema ");
                userService.registraUsuario(userBE);
                flagRegistro = true;
            } catch(ApplicationException e) {
                System.out.println(e.getMessage());
            }
        }
        userBE = userService.validateLogin(userBE.getUsername(), userBE.getPassword());
        System.out.println( "Informacion de usuario registrado: " );
        System.out.println( "username = " + userBE.getUsername());
        System.out.println( "userid = " + userBE.getUserId());
        System.out.println( "email = " + userBE.getEmail());
        System.out.println( "*********************");

    }

    public static void opcionActualizarPerfilUsuario() throws ParseException {
        System.out.println( "******ACTUALIZAR PERFIL***************");
        Scanner in = new Scanner(System.in);
        UserService userS = new UserService();
        User userBE = signin();

        System.out.println("Actualizando perfil de Usuario: " + userBE.getUsername());
        String firstName;
        System.out.print("Nombre:  ");
        firstName = in.nextLine();
        userBE.setFirstName(firstName);

        String lastName;
        System.out.print("Apellido:  ");
        lastName = in.nextLine();
        userBE.setLastName(lastName);

        String sex;
        System.out.print("Sexo (M o F):  ");
        sex = in.nextLine();
        userBE.setSex(sex);

        String birthday;
        System.out.print("Fecha Nacimiento dd/MM/yyyy:  ");
        birthday = in.nextLine();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date dayOfBirth = format.parse(birthday);
        userBE.setDateOfBirthday(dayOfBirth);

        userS.actualizarPerfilUsuario(userBE);
        userBE = userS.selectUserById(userBE.getUserId());

        System.out.println( "Informacion de usuario " + userBE.getUsername());
        System.out.println( "userid = " + userBE.getUserId());
        System.out.println( "Name = " + userBE.getFirstName());
        System.out.println( "Last Name = " + userBE.getLastName());
        System.out.println( "Sexo = " + userBE.getSex());
        System.out.println( "Birthday = " + userBE.getDateOfBirthday());
        System.out.println( "Password = " + userBE.getPassword());
        System.out.println( "email = " + userBE.getEmail());
        System.out.println( "*********************");

    }
}

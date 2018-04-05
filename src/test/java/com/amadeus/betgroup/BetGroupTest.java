package com.amadeus.betgroup;


import com.amadeus.betgroup.dao.polla.PollaHeaderDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.service.account.CreditService;
import com.amadeus.betgroup.service.account.FriendService;
import com.amadeus.betgroup.service.account.UserService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaMatchService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;
import com.amadeus.betgroup.service.template.TemplateDetailService;
import com.amadeus.betgroup.service.template.TemplateHeaderService;
import com.amadeus.betgroup.service.tournament.MatchService;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BetGroupTest {
    public static void main(String args[]) throws Exception{
        try{
/*
            System.out.print("Seleccione # Polla a visualizar detalle: ");
            String spollaId = in.nextLine();
            Integer pollaId = Integer.parseInt(spollaId);

            System.out.println( "Detalles de polla :" + pollaHeaderList.get(pollaId-1).getPollaName());
            PollaParticipantService pollaParticipantS = new PollaParticipantService();
            List<PollaParticipant> participantList = pollaParticipantS.getParticipantsByPollaId(pollaHeaderList.get(pollaId-1).getPollaId());
            System.out.println( "# de participantes " + participantList.size());
            System.out.println( "Imprimiendo lista de participantes:");
            for (int i=0; i < participantList.size(); i++ ) {

                PollaParticipant participante = participantList.get(i);
                System.out.println( participante.getUser().getEmail() + " - " + participante.getUser().getUsername() + " - " +
                                    participante.getUser().getFirstName() + " " + participante.getUser().getLastName() );
            }

            System.out.println( "*********************");
            System.out.println( "Detalles de eventos de polla :" + pollaHeaderList.get(pollaId-1).getPollaName());
            PollaMatchService pollaMatchS = new PollaMatchService();
            List<PollaMatch> pollaMatchList = pollaMatchS.getParticipantsByPollaId(pollaHeaderList.get(pollaId-1).getPollaId());
            System.out.println( "# de partidos " + pollaMatchList.size());
            System.out.println("Imprimiendo lista de partidos: ");
            for (int i=0; i < pollaMatchList.size(); i++ ) {

                PollaMatch pollaMatch = pollaMatchList.get(i);
                System.out.println( pollaMatch.getMatch().getMatchId() + " - " + pollaMatch.getMatch().getMatchCode() + ": " + pollaMatch.getMatch().getLocalTeam().getTeamName()
                + " vs "+ pollaMatch.getMatch().getVisitorTeam().getTeamName() + " - Dia: " + pollaMatch.getMatch().getMatchDate());
            }
            System.out.print("Seleccione el id Match a visualizar detalle: ");
            String sMatchId = in.nextLine();
            Integer matchId = Integer.parseInt(sMatchId);
            System.out.println( "Detalles de eventos de polla :" + pollaHeaderList.get(pollaId-1).getPollaName());
            MatchService matchS = new MatchService();
            Match match = matchS.getAllMatchInfoByMatchId(matchId);
            System.out.println( match.getGroup().getPhase().getTournament().getSport().getSportName());
            System.out.println( match.getGroup().getPhase().getTournament().getTournamentName());
            System.out.println( match.getGroup().getPhase().getPhaseName());
            System.out.println( match.getGroup().getGroupName());
            System.out.println( match.getMatchCode() +" - "+ match.getMatchDate());
            System.out.println( match.getLocalTeam().getTeamName() + " vs " + match.getVisitorTeam().getTeamName() );


            System.out.println( "*********************");
            FriendService friendS = new FriendService();
            userBE = friendS.getFriendListByUserId( userBE.getUserId() );
            System.out.println( "Numero de amigos: " + userBE.getFriendList().size() );
            System.out.println( "Imprimiendo lista de Amigos de " + userBE.getUsername() );

            for (int i=0; i < userBE.getFriendList().size(); i++ ){
                System.out.println( (i+1) + ": " + userBE.getFriendList().get(i).getAmigo().getFirstName() + " " + userBE.getFriendList().get(i).getAmigo().getLastName());
            }

*/          //opcionRegistrarUsuario();
            opcionMisPollas();
            opcionCrearJuego();
            opcionMisPollas();
            //    opcionJuegosDisponibles();

         //   opcionActualizarPerfilUsuario();
         //   historialCreditosByUser();


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
        System.out.print("Esta polla es privada. Ingrese el password de la polla para proceder a la inscripcion: ");
        while (!flagInscripCompleta){
            if (pollaHeader.getAccessFlag() != 0 ){
                String pollaPass = in.nextLine();
                if (pollaPass.contentEquals("CANCEL") ){
                    flagInscripCompleta = true;
                    flagInscripCancel = true;
                } else if ( pollaPass.contentEquals( pollaHeader.getPassword())){
                    pollaHeaderS.inscribirUsuarioEnPolla(pollaHeader, userBE);
                    flagInscripCompleta = true;
                }else{
                    System.out.print("El password de la polla es incorrecto. Ingrese nuevamente el password o digite CANCEL para salir:");
                }
            }
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
        System.out.println( "Informacion de usuario registrado" + userBE.getUsername());
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

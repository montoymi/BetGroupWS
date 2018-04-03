package com.amadeus.betgroup;

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
            UserService userS = new UserService();
            User userBE;
            String username = null;
            String password = null;

            Scanner in = new Scanner(System.in);
            System.out.print("Please enter user name : ");
            username = in.nextLine();
            System.out.print("Please enter password :");
            password = in.nextLine();

            userBE = userS.validateLogin(username,  password);
            System.out.println( "Informacion de usuario " + userBE.getUsername());
            System.out.println( "userid = " + userBE.getUserId());
            System.out.println( "Name = " + userBE.getFirstName());
            System.out.println( "email = " + userBE.getEmail());
            System.out.println( "*********************");

            CreditService creditS = new CreditService();
            Credit creditHistory = creditS.getCreditHistoryByUserId(userBE.getUserId());
            System.out.println( "Resumen de creditos para : " + userBE.getUsername() );
            System.out.println( "Total Creditos en cuenta = " + creditHistory.getTotalCreditos());
            System.out.println( "*********************");

            PollaHeaderService pollaHeaderS = new PollaHeaderService();
            List<PollaHeader> pollaHeaderList = pollaHeaderS.getMisPollasByUserId( userBE.getUserId());

            System.out.println( "Listado de Pollas Inscritas del usuario: " + userBE.getUsername());
            System.out.println( "Numero de pollas inscritas: " + pollaHeaderList.size());
            for (int i=0; i < pollaHeaderList.size(); i++ ){
                PollaHeader pollaHeader = pollaHeaderList.get(i);
                System.out.println( (i+1) + " # - ID: " + pollaHeader.getPollaId() + " - Nombre: " + pollaHeader.getPollaName() + " - Entrada: " + pollaHeader.getPollaCost() + "  -  Acceso: " + pollaHeader.getAccessFlag());
            }
            System.out.println( "*********************");

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

*/
            crearPolla();
            inscribirsePolla();
         //   registrarUsuario();
         //   actualizarPerfilUsuario();


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
    private static User signin(){
        System.out.println("******************************");
        System.out.println("******************************");
        System.out.println("Logueandose al sistema: ");

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter user name : ");
        String username = in.nextLine();
        System.out.print("Please enter password :");
        String password = in.nextLine();

        UserService userS = new UserService();
        User userBE = new User();
        boolean flagAcces = false;

        while (!flagAcces) {
            userBE = userS.validateLogin(username,  password);
            if ( userBE == null ){
                System.out.println("Credenciales invalidas. Ingrese un usuario y password nuevamente: ");
                System.out.print("Please enter user name : ");
                username = in.nextLine();
                System.out.print("Please enter password :");
                password = in.nextLine();
            }else{
                flagAcces = true;
            }
        }
        return userBE;
    }

    private static void inscribirsePolla() {
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

        while (!flagInscripCompleta){
            if (pollaHeader.getAccessFlag() != 0 ){
                System.out.print("Esta polla es privada. Ingrese el password de la polla para proceder a la inscripcion: ");
                String pollaPass = in.nextLine();
                if ( pollaPass.contentEquals( pollaHeader.getPassword())){
                    pollaHeaderS.inscribirUsuarioEnPolla(pollaHeader, userBE);
                    flagInscripCompleta = true;
                }else{
                    System.out.print("El password de la polla es incorrecto. Ingrese nuevamente ");
                }
            }
        }
    }

    private static void crearPolla() {
        System.out.println( "*********************");
        System.out.println( "Lista de plantillas habilitadas para crear juegos: ");
        TemplateHeaderService tempHeaderS = new TemplateHeaderService();
        List<TemplateHeader> templateHeaderList = tempHeaderS.getAllTemplateHeaderList();
        Scanner in = new Scanner(System.in);

        for (int i=0; i < templateHeaderList.size(); i++ ){
            System.out.println( (i+1) + ": " + templateHeaderList.get(i).getTemplateName());
        }

        System.out.print("Seleccione # Juego disponible a visualizar eventos: ");
        String sTemHeaderId = in.nextLine();
        Integer tempHeaderId = Integer.parseInt(sTemHeaderId);


        System.out.println( "Detalles de eventos de polla :" + templateHeaderList.get(tempHeaderId-1).getTemplateName());
        TemplateDetailService templateDetailService = new TemplateDetailService();
        List<TemplateDetail> templateDetailList = templateDetailService.getAllTemplateHeaderList( templateHeaderList.get(tempHeaderId-1).getTemplateId());
        System.out.println( "# de partidos " + templateDetailList.size());
        System.out.println("Imprimiendo lista de partidos: ");
        for (int i=0; i < templateDetailList.size(); i++ ) {

            TemplateDetail templateDetail = templateDetailList.get(i);
            System.out.println( templateDetail.getMatch().getMatchId() + " - " + templateDetail.getMatch().getMatchCode() + ": " + templateDetail.getMatch().getLocalTeam().getTeamName()
                    + " vs "+ templateDetail.getMatch().getVisitorTeam().getTeamName() + " - Dia: " + templateDetail.getMatch().getMatchDate());
        }
    }

    public static void registrarUsuario(){
        String username = null;
        String password = null;
        String email = null;

        System.out.println("******************************");
        System.out.println("Formulario de Registro de Usuario: ");
        Scanner in = new Scanner(System.in);

        UserService userService = new UserService();
        User userBE;

        boolean flagRegistro = false;
        while (!flagRegistro)  {
            System.out.print("Porfavor, ingrese su username: ");
            username = in.nextLine();
            userBE = userService.checkUsernameExists(username);
            if( userBE != null ){
                System.out.println("Este username ya se encuentra usado. Porfavor, ingrese otro nickname: ");
            }else{
                flagRegistro = true;
            }
        }

        flagRegistro = false;
        while (!flagRegistro)  {
            System.out.print("Porfavor, ingrese su email: ");
            email = in.nextLine();
            userBE = userService.checkEmailExists(email);

            if( userBE != null ){
                System.out.println("Este email ya se encuentra usado. Porfavor, ingrese otro email: ");
            }else{
                flagRegistro = true;
            }
        }

        flagRegistro = false;
        while (!flagRegistro) {
            System.out.print("Porfavor, ingrese el password de su cuenta: ");
            password = in.nextLine();
            System.out.print("Porfavor, confirme el password otra vuelta: ");
            String password2 = in.nextLine();
            if ( password.contentEquals(password2)){
                flagRegistro = true;
            } else{
                System.out.println("Los passwords no coinciden. Ingrese el nuevo password otra vuelta: ");
            }
        }

        System.out.println("Procediendo a registrar al usuario en el sistema ");

        userBE = new User();
        userBE.setEmail(email);
        userBE.setUsername(username);
        userBE.setPassword(password);

        userService.registraUsuario(userBE);
        userBE = userService.validateLogin(userBE.getUsername(), userBE.getPassword());

        System.out.println( "Informacion de usuario registrado" + userBE.getUsername());
        System.out.println( "userid = " + userBE.getUserId());
        System.out.println( "email = " + userBE.getEmail());
        System.out.println( "*********************");

        /*

        System.out.print("Porfavor, ingrese su correo electronico: ");
        email = in.nextLine();
        System.out.print("Porfavor, ingrese el password a usar: ");
        password = in.nextLine();
*/
    }

    public static void actualizarPerfilUsuario() throws ParseException {
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

        User user = new User();
    }
}

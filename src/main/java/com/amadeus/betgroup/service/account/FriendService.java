package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.FriendDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.commons.EmailService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;

import java.util.List;

public class FriendService {
    private FriendDAO friendDAO = new FriendDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void followFriend(int userId, int friendId) {
        Friend friend = new Friend();
        friend.setIdUser( userId );
        friend.setIdFriend( friendId );

        if ( userId == friendId ){
            throw new ApplicationException("FR001"); // Seleccione otro usuario a seguir que no sea usted mismo. El proceso ha sido cancelado.
        }else if (friendDAO.checkUserIsNotFriend(friend).size() !=0) {
            throw new ApplicationException("FR002"); // Ud. ya tiene agregado a este usuario como amigo. El proceso ha sido cancelado.
        }
        else{
            friendDAO.followFriend( friend );
        }
    }

    public void unfollowFriend( int friendId ) {
        friendDAO.unfollowFriend( friendId );
    }

    public List<Friend> getFriendListByUserId(int user_id) {
        return friendDAO.getFriendListByUserId( user_id );
    }

    public void inviteFriendByEmail( int userId, String email, int pollaHeaderId ){
        UserService userService = new UserService();
        User emisor = userService.selectUserById(userId);
        User invitado = userService.getUserByEmail(email);

        if (invitado != null){
            PollaParticipantService pollaParticipantService = new PollaParticipantService();
            PollaParticipant pollaParticipant = pollaParticipantService.getPollaParticipantByPollaId(pollaHeaderId, invitado.getUserId() );
            if ( pollaParticipant !=  null ){
                throw new ApplicationException("INVAMIG001");
                //Este usuario ya esta inscrito en este juego.
            }else{
                //if ya ha sido invitado anteriormente, no se le podra enviar otra invitacion.
                //Esto va a necesitar que se manejen invitaciones, el cual no tenemos a la fecha.
            }
        }

        PollaHeaderService pollaHeaderService = new PollaHeaderService();
        PollaHeader pollaHeader = pollaHeaderService.getPollaById( pollaHeaderId);
        User pollaAdmin = userService.selectUserById( pollaHeader.getAdminId() );

        //TODO: Esto deberia jalar de BD el codigo con la notificacion q se debe enviar al usuario por invitacion un Juego.
        String subject = "BetGroupSports - Invitacion a Juego";
        String message = "Hola " + (invitado==null?email:invitado.getUsername()) + ", el usuario " + emisor.getUsername() + " te ha invitado al juego: '" + pollaHeader.getPollaName() + "', ";
//        message += "', el cual es administrado por el usuario: " + pollaHeader.getAdmin().getUsername() + "." ;

        if ( pollaHeader.getAccessFlag() == 1){ //1: Polla Privada
            message += "Esta polla es privada y el password para que te puedas inscribir es:" + pollaHeader.getPassword() + ". ";
        }else{ // 0: Polla Publica
            message += "Esta polla es publica, asi que solo necesitaras inscribirte. ";
        }
        if ( pollaHeader.getCostFlag() == 1 ){
            message += "Esta polla tiene un costo de inscripcion y necesitaras " + pollaHeader.getPollaCost() + " creditos, para inscribirte al juego.";
        }else{
            message += "Esta polla no tiene ningun costo.";
        }
        message += " Este juego empieza el  " + pollaHeader.getStartDate() ;
        message += ". Esperamos poder contar con tu participacion.";

        EmailService.sendEmail( invitado==null?email:invitado.getEmail(), subject, message);
    }

    public void inviteFriendByUserId( int userId, int friendId, int pollaHeaderId ){
        UserService userService = new UserService();
        User emisor = userService.selectUserById(userId);
        User invitado = userService.selectUserById(friendId);

        PollaHeaderService pollaHeaderService = new PollaHeaderService();
        PollaHeader pollaHeader = pollaHeaderService.getPollaById( pollaHeaderId);
        User pollaAdmin = userService.selectUserById( pollaHeader.getAdminId() );

        if (invitado != null){
            PollaParticipantService pollaParticipantService = new PollaParticipantService();
            PollaParticipant pollaParticipant = pollaParticipantService.getPollaParticipantByPollaId(pollaHeaderId, invitado.getUserId() );
            if ( pollaParticipant ==  null ){
                throw new ApplicationException("INVAMIG001");
                //Este usuario ya esta inscrito en este juego.
            }
        }

        //TODO: Esto deberia jalar de BD el codigo con la notificacion q se debe enviar al usuario por invitacion un Juego.
        String subject = "BetGroupSports - Invitacion a Juego";
        String message = "Hola " + invitado.getUsername() + ", el usuario " + emisor.getUsername() + " te ha invitado al juego: '" + pollaHeader.getPollaName() + "'. ";
//        message += "', el cual es administrado por el usuario: " + pollaAdmin.getUsername() + "." ;

        if ( pollaHeader.getAccessFlag() == 1){ //1: Polla Privada
            message += "Esta polla es privada y el password para que te puedas inscribir es:" + pollaHeader.getPassword();
        }else{ // 0: Polla Publica
            message += "Esta polla es publica, asi que solo necesitaras inscribirte. ";
        }
        if ( pollaHeader.getCostFlag() == 1 ){
            message += "Esta polla tiene un costo y necesitara " + pollaHeader.getPollaCost() + " creditos, para inscribirte a la polla.";
        }else{
            message += "Esta polla no tiene ningun costo.";
        }
        message += " Este juego empieza el " + pollaHeader.getStartDate() ;
        message += ". Esperamos poder contar con tu participacion.";
        EmailService.sendEmail( invitado.getEmail(), subject, message);
    }
}

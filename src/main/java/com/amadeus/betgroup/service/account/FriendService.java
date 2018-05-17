package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.FriendDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.commons.EmailService;
import com.amadeus.betgroup.service.config.ParamValueService;
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

    public void inviteFriend( String emisorEmail, String invitadoEmail, int pollaHeaderId, String lang ){
        UserService userService = new UserService();
        User invitado = userService.getUserByEmail(invitadoEmail);

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
		ParamValueService paramValueService = new ParamValueService();
		ParamValue paramValue = paramValueService.getInviteMessage( emisorEmail, invitadoEmail, pollaHeaderId, lang);
		String subject = paramValue.getParamValueString1();
		String message = paramValue.getParamValueString2();

		EmailService.sendEmail( invitadoEmail, subject, message);

    }

}

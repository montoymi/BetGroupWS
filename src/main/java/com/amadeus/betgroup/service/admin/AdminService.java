package com.amadeus.betgroup.service.admin;

import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.model.config.SlideIonic;
import com.amadeus.betgroup.service.commons.EmailService;
import com.amadeus.betgroup.service.config.ParamValueService;

import java.util.ArrayList;
import java.util.List;

public class AdminService {

    public List<SlideIonic> getSlidesforInicioPage(String lang){
        ParamValueService paramValueService = new ParamValueService();
        List<SlideIonic> slideIonicList = paramValueService.getInitSlideIonicList( lang );
        return slideIonicList;
    }

    public void contactenos( int user_id, String asunto, String mensaje ){

    //    EmailService.sendEmail(destinatario, subject, contenido);

    }



    public void notifyUsersOfBetsByMatchId(  ){
// Obtener todas las pollas activas o en juego que tengan asociadas un especifico match.
// Obtener todas las apuestas de cada polla     int matchId

   //     PollaHeader pollaHeader = new PollaHeader();
  //      PollaMatch pollaMatch = new PollaMatch();

   //     System.out.println("Aca los pronosticos de la polla: " + pollaHeader.getPollaName() );
    //    System.out.println("para el partido : " + pollaMatch.getMatch().getLocalTeam().getTeamName() + " vs " + pollaMatch.getMatch().getVisitorTeam().getTeamName() );

//traer todos los participantes de una polla

 //       pollaHeader.getPollaParticipantList();
 //       PollaParticipant pollaParticipant = new PollaParticipant();
   //     pollaParticipant.getUser().getUsername();

        String contenido = "Aca los pronosticos de la polla: PRONTO EL LISTADO - ESTAMOS TRABAJANDO ";
        String destinatario = "er.morales@gmail.com";
        String subject =  "BETGROUPSPORTS - Pronósticos XXX  vs. YYYY ";

        String cadena = EmailService.sendEmail(destinatario, subject, contenido);
        if ( cadena.equalsIgnoreCase("")){
            System.out.println("Correo enviado satisfactoriamente....." );
        }



    }
/*
    public String sendMailListBetsByMatchId( int betgroups_id, int match_id ) throws Exception{
        String result = "";
        String cadena = "";
        int mails_enviados = 0;
        int mails_totales = 0;

        List l_bets = betDA.getAllResultsByMatchByBG(betgroups_id, match_id);
        UserBL userBL = new UserBL(connection);

        MatchBE matchBE = matchDA.getMatchById(match_id);
        BetGroupBE betgroupBE = betgroupDA.getBetGroupById(betgroups_id);

        Iterator it = l_bets.iterator();
        while (it.hasNext()){
            BetBE betBE = (BetBE)it.next();

            UserBE userBE = userBL.getUserById( betBE.getBetGroupPlayerBE().getUser_id() );


            //     if( userBE.getNick_name().equalsIgnoreCase("kcire") || userBE.getNick_name().equalsIgnoreCase("MARCUS LYCUS")){
            String contenido = armaContenido( matchBE, userBE, l_bets);
            String destinatario = userBE.getEmail_address();
            String subject = betgroupBE.getBetsgroup_name() + " - Pronósticos " + matchBE.getLocalBE().getTeam_name() + " vs. " + matchBE.getVisitorBE().getTeam_name();

            cadena = EmailService.sendEmail(destinatario, subject, contenido);
            mails_totales++;
            if ( cadena.equalsIgnoreCase("")){
                mails_enviados++;
            }

            //     }
        }

        result = "Se enviaron " + mails_enviados + " de " + mails_totales + " emails.";
        return result;


    }
*/
}

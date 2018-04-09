package com.amadeus.betgroup.service;

import com.amadeus.betgroup.dao.PersonDAO;
import com.amadeus.betgroup.model.Person;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

public class PersonService {
    private PersonDAO personDAO = new PersonDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void createPerson(Person person) {
        personDAO.createPerson(person);
    }

    public void updatePerson(Person person) {
        personDAO.updatePerson(person);
    }

    public Person getPersonById(int id) {
        return personDAO.getPersonById(id);
    }

/*
    private void btnSendEmail_onclick() throws Exception {
        BetGroupPlayerBE bgpAdminBE = (BetGroupPlayerBE)session.getAttribute("admin_bgpBE");
        BetBE betBE = bgpAdminBE.getL_betBe().get(ind);
        MatchBE matchBE = betBE.getMatchBE();
        String result = betBL.sendMailListBetsByMatchId(bgpAdminBE.getBetsgroup_id(), matchBE.getMatch_id() );
        MessageFrame mf = new MessageFrame();
        mf.setMensaje(result);
    }

    private void btnSendBlank_onclick() throws Exception {
        BetGroupPlayerBE bgpAdminBE = (BetGroupPlayerBE)session.getAttribute("admin_bgpBE");
        bgpAdminBE.getBetGroupBE();
        BetBE betBE = bgpAdminBE.getL_betBe().get(ind);
        MatchBE matchBE = betBE.getMatchBE();
        String result = betBL.sendMailListBetsBlankByMatchId(bgpAdminBE.getBetsgroup_id(), matchBE.getMatch_id() );
        MessageFrame mf = new MessageFrame();
        mf.setMensaje(result);
    }

    public List<BetBE> getAllBetsByBetGroupPlayerId( int betgroup_player_id) throws Exception{
        List<BetBE> l_bet =new ArrayList<BetBE>();
        LookupDA lookupDA = new LookupDA(connection);

        String limitTime = lookupDA.getLookupDescription("BETGROUPS", "ACTIVE_MATCH", "HOURS");
        BetDA betDA = new BetDA(connection);
        List l_bets = betDA.getAllBetsByBetGroupPlayerId(betgroup_player_id);

        Iterator it = l_bets.iterator();
        while (it.hasNext()){
            BetBE betBE = (BetBE)it.next();

            if( betBE.getMatchBE().getEnabled_flag().equals("Y")){
                boolean ok = validateBet(limitTime, betBE.getMatchBE().getMatch_date() );
                if( !ok){
                    betBE.getMatchBE().setEnabled_flag("N");
                    betDA.actualizarStatus( betBE.getMatchBE().getMatch_id(), "N");

                }
            }
            l_bet.add(betBE);
        }
        return l_bet;
    }
    public static Date newDateMinusHours(Date dtFecha, String hoursSt){
        Calendar cal = new GregorianCalendar();
        cal.setTimeInMillis(dtFecha.getTime());
        int hours = (Integer.parseInt(hoursSt))*-1;
        cal.add(Calendar.HOUR, hours );
        return new Date(cal.getTimeInMillis());
    }

    public Date getSystemDate() throws Exception{
        ResultSet resultSet = null;
        Date result = null;
        ArrayList<Parameter> l_parametros = null;

        try{
            String functionPSQL = "now";

            resultSet = Queries.obtieneCursor(conexion.getConnection(), functionPSQL, l_parametros);
            if (resultSet.next()){

                Timestamp timestamp = resultSet.getTimestamp(1);

                if (timestamp != null)
                    result = new Date(timestamp.getTime());
            }

            return result;
        } catch( Exception e){
            e.printStackTrace();
            throw e;
        } finally {
            if (resultSet != null) resultSet.close();
        }
    }

    public boolean validateBet(String limitTime, Date match_date) throws Exception {
        boolean flag = false;
        Util util = new Util(connection);

        Date limitDate = Util.newDateMinusHours(match_date, limitTime);
        Date sysDate = util.getSystemDate();

        if( sysDate.before(limitDate) ) flag = true;

        return flag;
    }

    public String getResult_bet(int local_result, int visitor_result) {
        String result;

        if ( local_result == visitor_result )
            result = "E";
        else if ( local_result > visitor_result )
            result = "L";
        else
            result = "V";

        return result;
    }

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

                cadena = Email.sendEmail(destinatario, subject, contenido);
                mails_totales++;
                if ( cadena.equalsIgnoreCase("")){
                    mails_enviados++;
                }

       //     }
        }

        result = "Se enviaron " + mails_enviados + " de " + mails_totales + " emails.";
        return result;
    }


    public String sendMailListBetsBlankByMatchId( int betgroups_id, int match_id ) throws Exception{

        String result = "";
        String cadena = "";
        int mails_enviados = 0;
        int mails_totales = 0;
        try{
            BetGroupDA betgroupDA = new BetGroupDA(connection);
            BetDA betDA = new BetDA(connection);
            MatchDA matchDA = new MatchDA(connection);

            List l_bets = betDA.getAllResultsByMatchByBG(betgroups_id, match_id);
            UserBL userBL = new UserBL(connection);

            MatchBE matchBE = matchDA.getMatchById(match_id);
            BetGroupBE betgroupBE = betgroupDA.getBetGroupById(betgroups_id);


            Iterator it = l_bets.iterator();
            while (it.hasNext()){
                BetBE betBE = (BetBE)it.next();
                betBE.setBetGroupBE(betgroupBE);
                UserBE userBE = userBL.getUserById( betBE.getBetGroupPlayerBE().getUser_id() );

//                if( userBE.getNick_name().equalsIgnoreCase("kcire") || userBE.getNick_name().equalsIgnoreCase("MARCUS LYCUS")){

                    if( ( betBE.getLocal_result() == -1 )|| ( betBE.getVisitor_result()==-1 ) ){
                        mails_totales++;
                        String contenido = armaContenidoBlank( matchBE, userBE);
                        String destinatario = userBE.getEmail_address();
                        String subject = betBE.getBetGroupBE().getBetsgroup_name() + " - Partido en blanco " + matchBE.getLocalBE().getTeam_name() + " vs. " + matchBE.getVisitorBE().getTeam_name();

                        cadena = Email.sendEmail(destinatario, subject, contenido);
                        if ( cadena.equalsIgnoreCase("")){
                            mails_enviados++;
                        }
                    }
//                }
            }

            result = "Se enviaron " + mails_enviados + " de " + mails_totales + " emails a usuarios con resultados no llenados para el partido seleccionado.";
            return result;
        } catch(Exception e){
            throw e;
        }
        finally{
            connection.close();
        }

    }

    public String armaContenido( MatchBE matchBE, UserBE userBE, List<BetBE> l_bets ){
        String contenido;


        contenido = "<h1 style=\"color: #006dcc\" >Hola " + userBE.getFull_name() + " </h1>";
        contenido += "Este correo contiene las apuestas del partido " + matchBE.getLocalBE().getTeam_name() + " -  " + matchBE.getVisitorBE().getTeam_name() + ". ";
        contenido += " Este partido empieza el "+ matchBE.getMatch_date() + ". ";
        contenido += "<br>";
        contenido += "Dicho partido ya se encuentra cerrado de manera automática y ya no permite modificación alguna a ninguno de los jugadores.";
        contenido += "<br>";
        contenido += "Suerte con tus resultados. Podrás ver tus resultados en la página web, Link \"Ranking\".";
        contenido += "<br>";
        contenido += "<br>";
        contenido += "Atentamente";
        contenido += "<br>";
        contenido += "<a href=www.lapollademiamigo.com\">www.lapollademiamigo.com</a>";
        contenido += "<br>";
        contenido += "<br>";
        contenido += "<table align=\"left\" class=\"table-custom\">";
        contenido += "<thead>";
        contenido += "<tr class=\"td-custom\">";
        contenido += "<th class=\"label-info\">Nickname</th>";
        contenido += "<th class=\"label-info\">Local</th>";
        contenido += "<th class=\"label-info\">Visitante</th>   ";
        contenido += "</tr>";
        contenido += "</thead>";

        Iterator i = l_bets.iterator();
        while (i.hasNext()){
            BetBE betBE = (BetBE)i.next();

            contenido += "<tr class=\"tr-custom\" >";
            contenido += "<td align=\"left\" class=\"td-table-custom\">" + betBE.getBetGroupPlayerBE().getUserBE().getNick_name() + "</td>";

            if( betBE.getVisitor_result() == -1 || betBE.getLocal_result() == -1 ){
                contenido += "<td align=\"center\" class=\"td-table-custom\">  </td>";
                contenido += "<td align=\"center\" class=\"td-table-custom\">  </td>";
                contenido += "<td align=\"center\" class=\"td-table-custom\">  </td>";
            }
            else{
                contenido += "<td align=\"center\" class=\"td-table-custom\">" + betBE.getLocal_result() + "</td>";
                contenido += "<td align=\"center\" class=\"td-table-custom\">" + betBE.getVisitor_result() + "</td>";
                contenido += "<td align=\"center\" class=\"td-table-custom\">" + getResult_bet(betBE.getLocal_result() , betBE.getVisitor_result()) + "</td>";
            }

            contenido += "</tr> ";
        }
        contenido += "<br>";
        contenido += "<br>";
        contenido += "</tbody>";
        contenido += "</table>";
        contenido += "<br>";
        return contenido;
    }


    <h1 style="color: #006dcc" >Hola Erick Morales</h1>
            Este correo contiene las apuestas del partido Brasil - Croacia. Este partido empieza a las 13:00

            Dicho partido ya se encuentra cerrado de manera automática y ya no permite modificación alguna a ninguno de los jugadores.
            Suerte con tus resultados. Podrás ver tus resultados en la página web, Link "Ranking".
            <br>
            <br>
            Atentamente
            <br>
            <a href=www.lapollademiamigo.com">www.lapollademiamigo.com</a>
            <br>
            <br>
            <table align="left" class="table-custom">
                <thead>
                    <tr class="td-custom">
                        <th class="label-info">Nickname</th>
                        <th class="label-info">Nombres</th>
                        <th class="label-info">Local</th>
                        <th class="label-info">Visitate</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="tr-custom" >
                        <td align="center" class="td-table-custom">KCIRE</td>
                        <td align="center" class="td-table-custom">Erick Morales</td>
                        <td align="center" class="td-table-custom">3</td>
                        <td align="center" class="td-table-custom">1</td>
                    </tr>
                </tbody>
            </table>


    private String armaContenidoBlank(MatchBE matchBE, UserBE userBE) {
        String contenido;


        contenido = "<h1 style=\"color: #006dcc\" >Hola " + userBE.getFull_name() + " </h1>";
        contenido += "No te olvides de actualizar tu apuesta para el partido " + matchBE.getLocalBE().getTeam_name() + " -  " + matchBE.getVisitorBE().getTeam_name() + " ";
        contenido += " Este partido empieza el "+ matchBE.getMatch_date() + ". Nos hemos dado cuenta que aun no has registrado tu resultado, y ya falta poco para que puedas cambiar tu score.";
        contenido += " No pierdas la oportunidad de seguir sumando puntos.";
        contenido += "<br>";
        contenido += "Suerte con tus resultados. Podrás ver los resultados en la página web, Link \"Ranking\".";
        contenido += "<br>";
        contenido += "<br>";
        contenido += "Atentamente";
        contenido += "<br>";
        contenido += "<a href=www.lapollademiamigo.com\">www.lapollademiamigo.com</a>";
        contenido += "<br>";
        contenido += "<br>";


        return contenido;

    }
    */
}


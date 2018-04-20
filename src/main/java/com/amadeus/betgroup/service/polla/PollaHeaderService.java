package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaHeaderDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.account.CreditService;

import java.util.List;

public class PollaHeaderService {
    private PollaHeaderDAO pollaHeaderDAO = new PollaHeaderDAO(MyBatisSqlSession.getSqlSessionFactory());


    public List<PollaHeader> getMisPollasByUserId(int userId) {
        List<PollaHeader> pollaList = pollaHeaderDAO.getMisPollasByUserId(userId);

        return pollaList;
    }

    public List<PollaHeader> getPollasDisponiblesByUserId(int userId) {
        List<PollaHeader> pollaList = pollaHeaderDAO.getPollasDisponiblesByUserId(userId);

        return pollaList;
    }

    public void inscribirUsuarioEnPolla(PollaHeader pollaHeader, User userBE) {

        pollaHeader.getCostFlag();

        CreditService creditS = new CreditService();
        Credit credit = creditS.getCreditSummaryByUserId(userBE.getUserId());

        if( pollaHeader.getPollaCost() > credit.getTotalCreditos() ){
            System.out.println(" No tiene creditos suficientes para inscribirse en la polla.");
        }
    }

    public void crearPolla (PollaHeader pollaHeader) throws ApplicationException {
        try{
            CreditService creditS = new CreditService();
            //TODO: Revisar proceso de creditos
//            Credit creditHistory = creditS.getCreditHistoryByUserId(pollaHeader.getAdminId());
/*
            if( creditHistory.getTotalCreditos() < pollaHeader.getPollaCost() ){
                throw new ApplicationException();
                //System.out.println(" No tiene creditos suficientes para crear la polla.");
            }
*/
            pollaHeaderDAO.crearPolla(pollaHeader);


        }catch( Exception e){
            e.printStackTrace();
            throw e;
        }

    }

    public PollaHeader getPollaById(int id) {
        return pollaHeaderDAO.getPollaById(id);
    }

    public boolean validatePollaPassword(PollaHeader pollaHeader) {
        return pollaHeaderDAO.validatePollaPassword(pollaHeader);
    }

    public String showGameRules( int pollaHeaderId ){

        PollaHeaderService pollaHeaderService = new PollaHeaderService();
        PollaHeader pollaHeader = pollaHeaderService.getPollaById(pollaHeaderId);

        PollaParticipantService pollaParticipantService = new PollaParticipantService();
        pollaHeader.setPollaParticipantList( pollaParticipantService.getParticipantListByPollaId(pollaHeader.getPollaId()));

        PollaMatchService pollaMatchS = new PollaMatchService();
        pollaHeader.setPollaMatchList( pollaMatchS.getPollaMatchesByPollaId(pollaHeader.getPollaId()) );



        pollaHeader.getAccessFlag();
        pollaHeader.getCostFlag(); // flag que indica que esa polla tendra un costo de :
        pollaHeader.getPollaCost();
        pollaHeader.getNumWildcards(); // numero de comodines si es que la template tiene modalida de juego con comodin.

        pollaHeader.getPollaParticipantList(); // cuantos participantes tiene
        pollaHeader.getPollaMatchList(); // cuantos partidos tiene
        pollaHeader.getPollaEventList(); //cuantas fechas tiene


        String reglas;
        if ( (pollaHeader.getModePollaFlag()==1) && (pollaHeader.getModePollitaFlag()==1) ) {
            reglas = "Ud. ha seleccionado dos modalidades de Juego: 'Pozo Global' y 'Pozo por Fecha'. ";
            reglas+= "La distribucion de la premiacion se basara segun el pozo total acumulado entre todos los participantes. /n ";
            reglas+= "1 - El 60% del pozo total acumulado, se repartira a la modalidad de juego 'Pozo Global'.";
            reglas+= "En esta modalidad solo se tendra un ganador, o ganadores, los cuales obtuvieron la mas alta puntuacion.";
            reglas+= "2 - El 30% del pozo total acumulado, se repartira para el modo de juego 'Pozo por Fecha'.";
            reglas+= "Este pozo se repartira entre todas las fechas definidas para ese juego. " +
                    "Habra uno o varios ganadores en cada fecha, siempre que hayan obtenido la maxima puntuacion dentro de cada fecha.";
            reglas+= "3 - El 10% del pozo total acumulado, se quedara como comision de la casa.";
        } else if ( pollaHeader.getModePollaFlag() == 1 ){
            reglas = "Ud. ha seleccionado la  modalidad de Juego: 'Pozo Global'.";
            reglas+= "La distribucion de la premiacion se basara segun el pozo total acumulado entre todos los participantes. /n ";
            reglas+= "1 - El 90% del pozo total acumulado, se repartira a la modalidad de juego 'Pozo Global'.";
            reglas+= "En esta modalidad solo se tendra un ganador, o ganadores, los cuales obtuvieron la mas alta puntuacion.";
            reglas+= "2 - El 30% del pozo total acumulado, se repartira para el modo de juego 'Pozo por Fecha'.";
            reglas+= "Este pozo se repartira entre todas las fechas definidas para ese juego. " +
                     "Habra uno o varios ganadores en cada fecha, siempre que hayan obtenido la maxima puntuacion dentro de cada fecha.";
            reglas+= "3 - El 10% del pozo total acumulado, se quedara como comision de la casa.";
        } else {

        }

        return "";
    }


    /*

    BetGroupBE bgBE = bgpBE.getBetGroupBE();

    int id = bgBE.getBetsgroup_id();
    BetGroupBL betGroupBL = new BetGroupBL( connection );
    List<BetGroupPlayerBE> l_ranking = betGroupBL.getRankingByBetGroupId(id);
    bgBE.setL_bgp(l_ranking);


    public List<BetGroupPlayerBE> getRankingByBetGroupId( int betgroup_id ) throws Exception{
        List<BetGroupPlayerBE> l_betGroupsUser =new ArrayList<BetGroupPlayerBE>();

        try{
            BetGroupPlayerDA bgpDA = new BetGroupPlayerDA(connection);

            return bgpDA.getRankingByBetGroupId(betgroup_id);
        } catch( Exception e){
            throw e;
        }
    }

    public List<BetBE> getRankDetailByBetGroupPlayer( BetGroupPlayerBE bgpBE ) throws Exception{

        List<BetBE> l_rankdet_bet = new ArrayList<BetBE>();
        BetBL betBL = new BetBL( connection );
        List<BetBE> l_bet = betBL.getAllBetsByBetGroupPlayerId(bgpBE.getBetgroup_player_id());

        Iterator i = l_bet.iterator();

        while (i.hasNext()){
            BetBE betBE = (BetBE)i.next();

            if( betBE.getMatchBE().getEnabled_flag().equalsIgnoreCase("N")){
                l_rankdet_bet.add(betBE);
            }
            betBE.setBetGroupPlayerBE(bgpBE);
        }

        return l_rankdet_bet;
    }
     */
}

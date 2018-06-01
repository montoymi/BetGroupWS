package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaHeaderDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.account.CreditService;
import org.apache.ibatis.exceptions.PersistenceException;

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

        if (pollaHeader.getPollaCost() > credit.getTotalCreditos()) {
            System.out.println(" No tiene creditos suficientes para inscribirse en la polla.");
        }
    }



    public void crearPolla(PollaHeader pollaHeader) {
        try {
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
        } catch (PersistenceException e) {
            throw new ApplicationException(e);
        } catch (Exception e) {
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

    public String showGameRules(PollaHeader pollaHeader, String lang) {
        return pollaHeaderDAO.getPollaGameRules(pollaHeader, lang);
    }

	public List<PollaHeader> getPollaHeaderListByMatchId(Integer matchId) {
		List<PollaHeader> pollaList = pollaHeaderDAO.getPollaHeaderListByMatchId(matchId);
		return pollaList;
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

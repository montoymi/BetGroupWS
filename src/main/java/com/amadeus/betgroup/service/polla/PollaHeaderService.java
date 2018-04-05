package com.amadeus.betgroup.service.polla;

import com.amadeus.betgroup.dao.polla.PollaHeaderDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
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
        Credit credit = creditS.getCreditHistoryByUserId(userBE.getUserId());

        if( pollaHeader.getPollaCost() > credit.getTotalCreditos() ){
            System.out.println(" No tiene creditos suficientes para inscribirse en la polla.");
        }
    }

    public void crearPolla (PollaHeader pollaHeader) throws ApplicationException {
        try{
            CreditService creditS = new CreditService();
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
}

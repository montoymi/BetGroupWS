package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.CreditDAO;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class CreditService {
    private CreditDAO creditDAO = new CreditDAO(MyBatisSqlSession.getSqlSessionFactory());

    public Credit getCreditSummaryByUserId(int userId) {
        Credit creditHeader = creditDAO.getCreditSummaryByUserID(userId);
        if( creditHeader == null){
            creditHeader = new Credit();
            creditHeader.setUserId( userId);
            creditHeader.setTotalCreditos( 0 );
        } else{
            List<CreditDetail> creditDetail = creditDAO.getCreditTransactionByUserId(userId);
            creditHeader.setCreditDetail(creditDetail);
        }
        return creditHeader;
    }

    public void addCreditTransaction(CreditDetail creditDetail){
        creditDAO.addCreditTransaction(creditDetail);
    }

    public void updateCreditTransaction(CreditDetail creditDetail){
        creditDAO.updateCreditTransaction(creditDetail);
    }

    public CreditDetail getCreditTransacionById( int crediDetailId ){
        CreditDetail creditDetail = creditDAO.getCreditTransacionById(crediDetailId);
        return creditDetail;
    }

    public List<CreditDetail> getAllPendingTransactions(){
        return creditDAO.getListAllCreditDetailPending();
    }

}

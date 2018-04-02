package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.CreditDAO;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class CreditService {
    private CreditDAO creditDAO = new CreditDAO(MyBatisSqlSession.getSqlSessionFactory());

    public Credit getCreditHistoryByUserId(int userId) {
        List<CreditDetail> creditDetail = creditDAO.getCreditTransactionByUserId(userId);


        Credit creditHeader = creditDAO.getTotalCreditosByUserID(userId);



        creditHeader.setCreditDetail(creditDetail);

        return creditHeader;
    }
}

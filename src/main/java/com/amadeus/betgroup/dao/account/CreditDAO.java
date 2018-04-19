package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CreditDAO {
    private SqlSessionFactory sqlSessionFactory;

    public CreditDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<CreditDetail> getCreditTransactionByUserId( int userId){
        SqlSession session = sqlSessionFactory.openSession();
        List<CreditDetail> creditDetails;
        try {
            creditDetails =session.selectList("CreditDetails.getCreditTransactionsByUserId", userId);
            session.commit();

        } finally {
            session.close();
        }
        return creditDetails;
    }

    public Credit getCreditSummaryByUserID(Integer userId) {
        Credit creditSummary;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            creditSummary = session.selectOne("Credits.getCreditSummaryByUserID", userId);
        } finally {
            session.close();
        }

        return creditSummary;
    }

    public void addCreditTransaction(CreditDetail creditDetail) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("CreditDetails.insertCreditTransaction", creditDetail);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateCreditTransaction(CreditDetail creditDetail) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("CreditDetails.updateCreditTransaction", creditDetail);
            session.commit();
        } finally {
            session.close();
        }
    }

    public CreditDetail getCreditTransacionById(int creditDetailId) {
        CreditDetail creditDetail;

        SqlSession session = sqlSessionFactory.openSession();

        try {
            creditDetail = session.selectOne("CreditDetails.selectCreditDetailById", creditDetailId);
        } finally {
            session.close();
        }
        return creditDetail;
    }

    public List<CreditDetail> getListAllCreditDetailPending(){
        SqlSession session = sqlSessionFactory.openSession();
        List<CreditDetail> creditDetailList = session.selectList("CreditDetails.getAllPendingCreditTransactions");
        return creditDetailList;
    }
}

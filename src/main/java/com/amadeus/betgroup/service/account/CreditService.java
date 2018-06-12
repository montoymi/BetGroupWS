package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.CreditDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class CreditService {
    private CreditDAO creditDAO = new CreditDAO(MyBatisSqlSession.getSqlSessionFactory());

    public Credit getCreditSummaryByUserId(int userId) {
        Credit creditHeader = creditDAO.getCreditSummaryByUserID(userId);
		if( creditHeader == null) {
			creditHeader = new Credit();
			creditHeader.setUserId(userId);
			creditHeader.setTotalCreditos(0);
		}
        return creditHeader;
    }

    public Credit getCreditDetailByUserId(int userId) {
        Credit creditHeader = creditDAO.getCreditSummaryByUserID(userId);
        if( creditHeader == null){
            creditHeader = new Credit();
            creditHeader.setUserId( userId);
            creditHeader.setTotalCreditos( 0 );
        } else{
            List<CreditDetail> creditDetail = creditDAO.getCreditTransactionByUserId(userId);
            creditHeader.setCreditDetailList(creditDetail);
        }
        return creditHeader;
    }

    public void comprarCreditos( CreditDetail creditDetail ){

        if ( creditDetail.getTransactionTypeId() == 1 ) {
            if( creditDetail.getCreditAmount() > 5000){ //TODO: Cambiar parametro estatico por dinamico desde la BD.
                throw new ApplicationException("CRE004");
                //No se puede comprar mas del maximo permitido en la aplicacion. Ingrese un monto a comprar no mayor a 5000
            } else if( creditDAO.checkPendingPurchaseExist(creditDetail.getUserId()) != null ){
                throw new ApplicationException("CRE005");
                //Existe una transaccion de compra pendiente de aprobacion. Esper a que se procese, para proceder con una nueva compra.
            } else{
                creditDetail.setStatus( 0 ); // 2pending to be approved by ADMIN
                creditDetail.setComments("Créditos comprados ");
                creditDAO.addCreditTransaction(creditDetail);
            }
        }else{
            throw new ApplicationException("CRE006");
            //Accion comprar creditos no es igual a tipo de transaccion con codigo 2
        }
    }

    public void cobrarCreditos( CreditDetail creditDetail ){
        if ( creditDetail.getTransactionTypeId() == 2 ) {
            if( creditDetail.getCredit().getTotalCreditos() < 1000 ){ //TODO: Cambiar parametro estatico por dinamico desde la BD.
                throw new ApplicationException("CRE001");  //Usuario tiene menos creditos que el minimo necesario para cobrar.
            } else if( creditDetail.getCredit().getTotalCreditos() < creditDetail.getCreditAmount() ){
                throw new ApplicationException("CRE002");
            } else{
                creditDetail.setStatus( 0 ); // pending to be approved by ADMIN
                creditDetail.setComments(" Creditos cobrados ");
                creditDAO.addCreditTransaction(creditDetail);
            }
        }else{
            throw new ApplicationException("CRE003"); //Accion cobrar creditos no es igual a tipo de transaccion con codigo 1
        }
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

package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.FriendDAO;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

public class FriendService {
    private FriendDAO friendDAO = new FriendDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void agregarAmigo(int userid , int amigoid) {
        friendDAO.agregarAmigo( userid, amigoid);
    }

    public User getFriendListByUserId(int user_id) {
        return friendDAO.getFriendListByUserId( user_id );
    }
}

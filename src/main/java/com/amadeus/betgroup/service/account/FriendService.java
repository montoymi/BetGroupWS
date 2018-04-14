package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.FriendDAO;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class FriendService {
    private FriendDAO friendDAO = new FriendDAO(MyBatisSqlSession.getSqlSessionFactory());

    public void followFriend(int userId, int friendId) {
        Friend friend = new Friend();

        friend.setIdUser( userId );
        friend.setIdFriend( friendId );

        if ( friendDAO.checkUserIsNotFriend(friend).size() !=0 ){
            //throw new ApplicationException("FR001");
            System.out.println("Ud. ya tiene agregado a este usuario como amigo. Proceso cancelado.");
        }else {
            friendDAO.followFriend( friend );
        }
    }

    public void unfollowFriend( int friendId ) {
        friendDAO.unfollowFriend( friendId );
    }

    public List<Friend> getFriendListByUserId(int user_id) {
        return friendDAO.getFriendListByUserId( user_id );
    }
}

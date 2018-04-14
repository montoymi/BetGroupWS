package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class FriendDAO {
    private SqlSessionFactory sqlSessionFactory;

    public FriendDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public List<Friend> checkUserIsNotFriend( Friend friend ){
        SqlSession session = sqlSessionFactory.openSession();
        List<Friend> friendList;
        try {
            friendList = session.selectList("Friend.checkUserIsNotFriend", friend );
        } finally {
            session.close();
        }
        return friendList;
    }

    public List<Friend> getFriendListByUserId(int user_id) {
        List<Friend> friendList;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            friendList = session.selectList("Friend.getFriendListByUserId", user_id);
        } finally {
            session.close();
        }
        return friendList;
    }

    public void followFriend(Friend friend) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("Friend.addFriend", friend);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void unfollowFriend( int id ){
        SqlSession session = sqlSessionFactory.openSession();
        Friend friend = new Friend();
        friend.setId( id );
        try {
            session.delete("Friend.deleteFriend", friend );
            session.commit();
        } catch( Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
    }
}

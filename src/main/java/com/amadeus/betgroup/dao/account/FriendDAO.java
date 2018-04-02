package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class FriendDAO {
    private SqlSessionFactory sqlSessionFactory;

    public FriendDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User getFriendListByUserId(int user_id) {
        User user;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            user = session.selectOne("Friend.getFriendListByUserId", user_id);
        } finally {
            session.close();
        }
        return user;
    }

    public void agregarAmigo(int userId , int amigoId) {

        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("Friend.agregarAmigo", userId);
            session.commit();
        } finally {
            session.close();
        }
    }
}

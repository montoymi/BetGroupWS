package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.config.Email;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
    private SqlSessionFactory sqlSessionFactory;

    public UserDAO(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public void actualizarPerfil(User user) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("User.actualizarPerfil", user);
            session.commit();
        } finally {
            session.close();
        }
    }


    public void registraUsuario(User user) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.insert("User.insertUser", user);
            session.commit();
        } finally {
            session.close();
        }
    }

    public User selectUserById(int userId) {
        User user;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            user = session.selectOne("User.selectUserById", userId);
        } finally {
            session.close();
        }

        return user;
    }

    public User validateLogin(String username, String password) {
        User user = new User();
        user.setUsername( username);
        user.setPassword( password );

        SqlSession session = sqlSessionFactory.openSession();

        try {
            user = session.selectOne("User.validateLogin", user);
            session.commit();

        } finally {
            session.close();
        }
        return user;
    }

    public User checkUsernameExists(String username){
        User user = new User();
        user.setUsername(username);

        SqlSession session = sqlSessionFactory.openSession();

        try{
            user = session.selectOne("User.checkUsernameExists", user);
        } finally{
            session.close();
        }
        return user;
    }

    public User checkEmailExists(String email){
        User user = new User();
        user.setEmail(email);

        SqlSession session = sqlSessionFactory.openSession();

        try{
            user = session.selectOne("User.checkEmailExists", user);
        } finally{
            session.close();
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> userList;
        SqlSession session = sqlSessionFactory.openSession();

        try {
            userList = session.selectList("User.selectAllUsers");
        } finally {
            session.close();
        }

        return userList;
    }

    public void changePassword(User user) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("User.changePassword", user);
            session.commit();
        } finally {
            session.close();
        }
    }
/*
    public Email forgotPassword2 (int userId, String lang ){
        SqlSession session = sqlSessionFactory.openSession();
        Email emailBE;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("lang", lang);
            emailBE = session.selectOne("User.forgotPassword", map);
            session.commit();
        } finally {
            session.close();
        }
        return emailBE;

    }
*/
    public String forgotPassword ( int userId, String lang ){
        SqlSession session = sqlSessionFactory.openSession();
        String message;
        try {
            Map<String, Object> map = new HashMap<>();
            map.put("userId", userId);
            map.put("lang", lang);

            message = session.selectOne("User.forgotPassword", map);
            session.commit();

        } finally {
            session.close();
        }
        return message;

    }

}

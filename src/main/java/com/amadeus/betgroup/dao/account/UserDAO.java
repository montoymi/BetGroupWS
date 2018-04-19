package com.amadeus.betgroup.dao.account;

import com.amadeus.betgroup.model.account.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

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

    public void cambiarPassword(User user) {
        SqlSession session = sqlSessionFactory.openSession();

        try {
            session.update("User.updateUserPassword", user);
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


}

package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.UserDAO;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

public class UserService {
    private UserDAO userDAO = new UserDAO(MyBatisSqlSession.getSqlSessionFactory());

    public User validateLogin(String username, String password) {
        return userDAO.validateLogin( username, password );
    }

    public User checkUsernameExists( String username ){
        return userDAO.checkUsernameExists(username);
    }

    public User checkEmailExists (String email){
        return userDAO.checkEmailExists(email);
    }

    public void registraUsuario(User user) {
        userDAO.registraUsuario(user);
    }

    public void  actualizarPerfilUsuario(User user){
        userDAO.actualizarPerfil(user);
    }

    public User selectUserById(int userId) {
        return userDAO.selectUserById( userId );
    }
}


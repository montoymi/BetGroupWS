package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.UserDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO(MyBatisSqlSession.getSqlSessionFactory());

    public User validateLogin(String username, String password) {
        return userDAO.validateLogin(username, password);
    }

    public void registraUsuario(User user) throws ApplicationException {
        validateUser(user);
        userDAO.registraUsuario(user);
    }

    public void actualizarPerfilUsuario(User user) {
        //TODO: Validadar los mismo pero considerar que el nickname
        //TODO: y email debe ser diferente solo a los de otros usuarios.
        //validateUser(user);
        userDAO.actualizarPerfil(user);
    }

    public User selectUserById(int userId) {
        return userDAO.selectUserById(userId);
    }

    private void validateUser(User user) {
        if (userDAO.checkUsernameExists(user.getUsername()) != null) {
            throw new ApplicationException("USR001");
        }

        if (userDAO.checkEmailExists(user.getEmail()) != null) {
            throw new ApplicationException("USR002");
        }
    }

    public List<User> getallUsers(){
        return userDAO.getAllUsers();
    }
}


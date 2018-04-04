package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.UserDAO;
import com.amadeus.betgroup.exception.ApplicationException;
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

    public void registraUsuario(User user) throws ApplicationException {
        User userBE;
        try{
            userBE = checkUsernameExists(user.getUsername());
            if( userBE != null ){
                throw new ApplicationException("USR001");
                //System.out.println("Este username ya se encuentra usado. Porfavor, ingrese otro nickname: ");
            }
            userBE = checkEmailExists(user.getEmail());
            if( userBE != null ){
                throw new ApplicationException("USR002");
                //System.out.println("Este email ya se encuentra usado. Porfavor, ingrese otro email: ");
            }
            userDAO.registraUsuario(user);
        } catch( Exception e ){
            throw  e;
        }

    }

    public void  actualizarPerfilUsuario(User user){
        userDAO.actualizarPerfil(user);
    }

    public User selectUserById(int userId) {
        return userDAO.selectUserById( userId );
    }
}


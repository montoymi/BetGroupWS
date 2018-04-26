package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.UserDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.commons.EmailService;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO(MyBatisSqlSession.getSqlSessionFactory());

    public User validateLogin(String username, String password) {
        userDAO.validateLogin(username, password);
        User user = userDAO.checkUsernameExists(username);

        return user;

    }

    public void registraUsuario(User user) throws ApplicationException {
        if (userDAO.checkUsernameExists(user.getUsername()) != null) {
            throw new ApplicationException("USR001");
        }
        if (userDAO.checkEmailExists(user.getEmail()) != null) {
            throw new ApplicationException("USR002");
        }
        userDAO.registraUsuario(user);
        sendWelcomeEmail(user);
    }

    private void sendWelcomeEmail( User user ){
        String subject = "BetGroup Sports - Usuario Registrado";
        String message = "<h1 style=\"color: #006dcc\" >Bienvenido a BetGroup Sports " + user.getUsername() + "! + </h1>";
        message += "<br>";
        message += "Esperamos puedas pasarla bien entre amigos y que puedas ganar uno que otro pozo que se esten organizando en la red. ";
        message += "Aqui tus credenciales para que puedas loguearte al sistema: USER= " + user.getUsername() + "  PASSWORD= " + user.getPassword();
        message += "Te deseamos la mejor de las suertes, y esperemos puedas ganar a tus amigos y demas acertando con tus pronosticos!";
        message += "<br>";
        message += "<br>";
        message += "Atentamente";
        message += "<br>";
        message+= "BetGroup Sports";

        EmailService.sendEmail( user.getEmail(), subject, message);

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

    public User getUserByEmail(String email) {
        return userDAO.checkEmailExists( email );
    }

    public List<User> getallUsers(){
        return userDAO.getAllUsers();
    }

    public void changePassword(User user) {
        userDAO.changePassword(user);
    }

}


package com.amadeus.betgroup.service.account;

import com.amadeus.betgroup.dao.account.UserDAO;
import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.config.Email;
import com.amadeus.betgroup.model.config.ParamValue;
import com.amadeus.betgroup.mybatis.MyBatisSqlSession;
import com.amadeus.betgroup.service.commons.EmailService;
import com.amadeus.betgroup.service.config.ParamValueService;
import com.sun.research.ws.wadl.Param;
import org.apache.ibatis.exceptions.PersistenceException;
import org.glassfish.jersey.jaxb.internal.XmlJaxbElementProvider;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO(MyBatisSqlSession.getSqlSessionFactory());

    public User validateLogin(String username, String password) {
        if ( userDAO.checkUsernameExists( username ) == null ){
            throw new ApplicationException("USR003");
            // El usuario ingresado no existe en el sistema. Porfavor, corrija e ingrese el username y trate de loguearse nuevamente.
        }
        User user = userDAO.validateLogin(username, password);
        if ( user == null ){
            throw new ApplicationException("USR004");
            //Las credenciales ingresadas no coinciden. Porfavolr, corrija e ingrese el password y trate de loguearse nuevamente.
        }
        return user;

    }

    public User registraUsuario(User user, String lang) throws ApplicationException {
        if (userDAO.checkUsernameExists(user.getUsername()) != null) {
            throw new ApplicationException("USR001");
        }
        if (userDAO.checkEmailExists(user.getEmail()) != null) {
            throw new ApplicationException("USR002");
        }
        user = userDAO.registraUsuario(user);

        sendWelcomeEmail(user, lang);

        return user;

    }

    public void forgotPassword( String email, String lang ){

        User user = userDAO.checkEmailExists(email);
        if  (user==null){
            throw new ApplicationException("USR005");
            //No existe usuario registrado con ese email
        }
        //TODO: Este subject debe ser de acuerdo al idioma seleccionado.
        String subject = "BetGroup Sports - Olvide Contrasenha";

        try {
       //     Email emailBE = userDAO.forgotPassword( user.getUserId(), lang );

            String message = userDAO.forgotPassword( user.getUserId(), lang );

            EmailService.sendEmail( (user.getEmail()==null)? email : user.getEmail() , subject, message);
        } catch (PersistenceException e) {
            throw new ApplicationException(e);
        }
    }

    private void sendWelcomeEmail( User user , String lang){
        ParamValueService paramValueService = new ParamValueService();

        ParamValue paramValue = paramValueService.getWelcomeMessage( user.getUsername(), lang );
    	String subject = paramValue.getParamValueString1();
    	String message = paramValue.getParamValueString2();

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


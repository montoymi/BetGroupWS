package com.amadeus.betgroup.rest.account;


import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.service.account.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class UserResource {
    private UserService userService = new UserService();

    @GET
    public Response validateLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        User user = userService.validateLogin(username, password);
        return Response.status(OK).entity(user).build();
    }

    @POST
    public Response registraUsuario(User user) {
        userService.registraUsuario(user);
        return Response.status(CREATED).entity(user).build();
    }

    @PUT
    public Response actualizarPerfilUsuario(User user) {
        userService.actualizarPerfilUsuario(user);
        return Response.status(CREATED).entity(user).build();
    }
}


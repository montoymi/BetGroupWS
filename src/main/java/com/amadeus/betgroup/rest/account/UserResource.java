package com.amadeus.betgroup.rest.account;


import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.service.account.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/users")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class UserResource {
    private UserService userService = new UserService();


    @GET
    public Response validateLogin(@QueryParam("username") String username, @QueryParam("password") String password) {
        User user = userService.validateLogin( username, password);
        return Response.status(OK).entity(user).build();
    }
}


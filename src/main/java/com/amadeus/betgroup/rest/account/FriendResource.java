package com.amadeus.betgroup.rest.account;

import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.service.account.FriendService;

import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.OK;

public class FriendResource {
    private FriendService friendService = new FriendService();


    @GET
    public Response agregarAmigo(@QueryParam("userId") int userId, @QueryParam("friendId") int friendId) {
        friendService.agregarAmigo( userId, friendId);
        return Response.status(OK).entity("").build();
    }
}

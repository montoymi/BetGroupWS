package com.amadeus.betgroup.rest.account;

import com.amadeus.betgroup.model.account.Friend;
import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.service.account.FriendService;
import com.amadeus.betgroup.service.account.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/friends")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class FriendResource {
    private FriendService friendService = new FriendService();
	private UserService userService = new UserService();

    @GET
    public Response getFriendListByUserId(@QueryParam("user-id") int userId) {
        List<Friend> friendList = friendService.getFriendListByUserId(userId);
        return Response.status(OK).entity(friendList).build();
    }

    @POST
    public Response followFriend(Friend friend) {
        friendService.followFriend(friend.getUser().getUserId(), friend.getAmigo().getUserId());
        return Response.status(OK).entity(friend).build();
    }

    @DELETE
    @Path("/{friend-id}")
    public Response unfollowFriend(@PathParam("friend-id") int friendId) {
        friendService.unfollowFriend(friendId);
        return Response.status(OK).entity(friendId).build();
    }

    @POST
    @Path("/{polla-id}")
    public Response inviteFriend(@PathParam("polla-id") int pollaId, Friend friend) {
    	friendService.inviteFriend( friend.getUser().getEmail() , friend.getAmigo().getEmail() , pollaId, friend.getUser().getPreferredLang());
        return Response.status(CREATED).entity(friend).build();
    }
}


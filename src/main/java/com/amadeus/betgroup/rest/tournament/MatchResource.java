package com.amadeus.betgroup.rest.tournament;

import com.amadeus.betgroup.model.tournament.Match;
import com.amadeus.betgroup.service.tournament.MatchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/matches")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MatchResource {
    private MatchService matchService = new MatchService();

    @GET
    @Path("/bets/{user-id}")
    public Response getMatchListWithBetsByUserId(@PathParam("user-id") int userId) {
        List<Match> matchList = matchService.getMatchListWithBetsByUserId(userId);
        return Response.status(OK).entity(matchList).build();
    }
}

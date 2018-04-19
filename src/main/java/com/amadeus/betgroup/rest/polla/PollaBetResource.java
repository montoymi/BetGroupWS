package com.amadeus.betgroup.rest.polla;

import com.amadeus.betgroup.model.polla.PollaBet;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.service.polla.PollaBetService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/bets")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PollaBetResource {
    private PollaParticipantService pollaParticipantService = new PollaParticipantService();
    private PollaBetService pollaBetService = new PollaBetService();

    @GET
    public Response getListBetsByPollaIdAndUserId(@QueryParam("polla-id") int pollaId, @QueryParam("user-id") int userId) {
        PollaParticipant pollaParticipant = pollaParticipantService.getPollaParticipantByPollaId(pollaId, userId);
        List<PollaBet> pollaBetList = pollaBetService.getListBetsByParticipantId(pollaParticipant.getPollaParticipantId());
        return Response.status(OK).entity(pollaBetList).build();
    }

    @POST
    public Response updatePollaBetByBetId(PollaBet pollaBet) {
        pollaBetService.updatePollaBetByBetId(pollaBet);
        return Response.status(CREATED).entity(pollaBet).build();
    }
}

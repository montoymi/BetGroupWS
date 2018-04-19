package com.amadeus.betgroup.rest.polla;

import com.amadeus.betgroup.model.polla.PollaMatch;
import com.amadeus.betgroup.service.polla.PollaMatchService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/polla-matches")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PollaMatchResource {
    private PollaMatchService pollaMatchService = new PollaMatchService();

    @GET
    @Path("/{polla-id}")
    public Response getPollaMatchesByPollaId(@PathParam("polla-id") int pollaId) {
        List<PollaMatch> pollaHeaderList = pollaMatchService.getPollaMatchesByPollaId(pollaId);
        return Response.status(OK).entity(pollaHeaderList).build();
    }
}

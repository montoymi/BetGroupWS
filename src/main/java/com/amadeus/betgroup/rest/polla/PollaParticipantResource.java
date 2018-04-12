package com.amadeus.betgroup.rest.polla;

import com.amadeus.betgroup.exception.ApplicationException;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.service.polla.PollaHeaderService;
import com.amadeus.betgroup.service.polla.PollaParticipantService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/participants")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PollaParticipantResource {
    private PollaParticipantService pollaParticipantService = new PollaParticipantService();
    private PollaHeaderService pollaHeaderService = new PollaHeaderService();

    @GET
    @Path("/{pollaId}")
    public Response getParticipantListByPollaId(@PathParam("pollaId") Integer pollaId) {
        List<PollaParticipant> pollaHeaderList = pollaParticipantService.getParticipantListByPollaId(pollaId);
        return Response.status(OK).entity(pollaHeaderList).build();
    }

    @POST
    public Response inscribirUserInBetgroup(PollaParticipant pollaParticipant) {
        PollaHeader pollaHeader = pollaParticipant.getPollaHeader();

        // Si es privado y el password es incorrecto
        if (pollaHeader.getAccessFlag() == 1 && !pollaHeaderService.validatePollaPassword(pollaHeader)) {
            throw new ApplicationException("INS001");
        }

        pollaParticipantService.inscribirUserInBetgroup(pollaParticipant);
        return Response.status(CREATED).entity(pollaParticipant).build();
    }
}

package com.amadeus.betgroup.rest.polla;

import com.amadeus.betgroup.model.account.User;
import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.service.account.UserService;
import com.amadeus.betgroup.service.polla.PollaHeaderService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/pollas")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PollaHeaderResource {
    private PollaHeaderService pollaHeaderService = new PollaHeaderService();

    @POST
    public Response crearPolla(PollaHeader pollaHeader) {
        pollaHeaderService.crearPolla(pollaHeader);
        return Response.status(CREATED).entity(pollaHeader).build();
    }

    @GET
    public Response getPollasByUserId(@QueryParam("user-id") int userId, @QueryParam("my-pollas") boolean myPollas) {
        List<PollaHeader> pollaHeaderList;

        if (myPollas) {
            pollaHeaderList = pollaHeaderService.getMisPollasByUserId(userId);
        } else {
            pollaHeaderList = pollaHeaderService.getPollasDisponiblesByUserId(userId);

        }

        return Response.status(OK).entity(pollaHeaderList).build();
    }

    @GET
    @Path("/{id}")
    public Response getPollaById(@PathParam("id") int id) {
        PollaHeader pollaHeader = pollaHeaderService.getPollaById(id);

        UserService userS = new UserService();
        User admin = userS.selectUserById(pollaHeader.getAdminId());
        pollaHeader.setAdmin(admin);

        return Response.status(OK).entity(pollaHeader).build();
    }

    @POST
    @Path("/rules")
    public Response getGameRules(PollaHeader pollaHeader) {
        String lang = pollaHeader.getLang();
        String rules = pollaHeaderService.showGameRules(pollaHeader, lang);
        pollaHeader.setRules(rules);
        return Response.status(OK).entity(pollaHeader).build();
    }
}

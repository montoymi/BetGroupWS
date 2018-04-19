package com.amadeus.betgroup.rest.account;

import com.amadeus.betgroup.model.account.Credit;
import com.amadeus.betgroup.model.account.CreditDetail;
import com.amadeus.betgroup.service.account.CreditService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/credits")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class CreditResource {
    private CreditService creditService = new CreditService();

    @GET
    public Response getCreditSummaryByUserId(@QueryParam("user-id") int userId) {
        Credit credit = creditService.getCreditSummaryByUserId(userId);
        return Response.status(OK).entity(credit).build();
    }

    @POST
    public Response addCreditTransaction(CreditDetail creditDetail) {
        creditService.addCreditTransaction(creditDetail);
        return Response.status(CREATED).entity(creditDetail).build();
    }
}

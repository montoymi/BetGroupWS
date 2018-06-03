package com.amadeus.betgroup.rest.config;

import com.amadeus.betgroup.model.config.SlideIonic;
import com.amadeus.betgroup.service.config.ParamValueService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/params")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ParamValueResource {
    private ParamValueService paramValueService = new ParamValueService();

    @GET
    @Path("/tutorial")
    public Response getPersonById(@QueryParam("lang") String lang) {
        List<SlideIonic> slideIonicList = paramValueService.getInitSlideIonicList(lang);
        return Response.status(OK).entity(slideIonicList).build();
    }

    @GET
    @Path("/terms")
    public Response getCondTerms(@QueryParam("lang") String lang) {
        String terms = paramValueService.getCondTerms(lang);
        String response = "{\"terms\":\"" + terms + "\"}";
        return Response.status(OK).entity(response).build();
    }
}

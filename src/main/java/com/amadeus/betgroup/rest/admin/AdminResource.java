package com.amadeus.betgroup.rest.admin;

import com.amadeus.betgroup.model.config.SlideIonic;
import com.amadeus.betgroup.service.admin.AdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/slides")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class AdminResource {
    private AdminService adminService = new AdminService();

    @GET
    @Path("/tutorial")
    public Response getPersonById(@QueryParam("lang") String lang) {
        List<SlideIonic> slideIonicList = adminService.getSlidesforInicioPage(lang);
        return Response.status(OK).entity(slideIonicList).build();
    }
}

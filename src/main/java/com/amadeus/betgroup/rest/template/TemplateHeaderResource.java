package com.amadeus.betgroup.rest.template;

import com.amadeus.betgroup.model.template.TemplateHeader;
import com.amadeus.betgroup.service.template.TemplateHeaderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/template-headers")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TemplateHeaderResource {
    private TemplateHeaderService templateHeaderService = new TemplateHeaderService();

    @GET
    public Response getAllTemplateHeaderList() {
        List<TemplateHeader> templateHeaderList = templateHeaderService.getAllTemplateHeaderList();
        return Response.status(OK).entity(templateHeaderList).build();
    }
}
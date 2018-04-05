package com.amadeus.betgroup.rest.template;

import com.amadeus.betgroup.model.template.TemplateDetail;
import com.amadeus.betgroup.service.template.TemplateDetailService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.Response.Status.OK;

@Path("/template-details")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class TemplateDetailResource {
    private TemplateDetailService templateDetailService = new TemplateDetailService();

    @GET
    @Path("/{template_header_id}")
    public Response getTemplateDetailsByTempHeader(@PathParam("template_header_id") int template_header_id) {
        List<TemplateDetail> templateDetailList = templateDetailService.getTemplateDetailsByTempHeader(template_header_id);
        return Response.status(OK).entity(templateDetailList).build();
    }
}
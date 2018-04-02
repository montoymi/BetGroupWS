package com.amadeus.betgroup.rest;

import com.amadeus.betgroup.model.Person;
import com.amadeus.betgroup.service.PersonService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.CREATED;
import static javax.ws.rs.core.Response.Status.OK;

@Path("/persons")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PersonResource {
    private PersonService personService = new PersonService();

    @POST
    public Response createPerson(Person person) {
        personService.createPerson(person);
        return Response.status(CREATED).entity(person).build();
    }

    @PUT
    public Response updatePerson(Person person) {
        personService.updatePerson(person);
        return Response.status(CREATED).entity(person).build();
    }

    @GET
    @Path("/{id}")
    public Response getPersonById(@PathParam("id") int id) {
        Person person = personService.getPersonById(id);
        return Response.status(OK).entity(person).build();
    }
}

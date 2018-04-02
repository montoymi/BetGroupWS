package com.amadeus.betgroup;

import com.amadeus.betgroup.rest.PersonResource;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.assertEquals;

public class PersonTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new MyResourceConfig();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(MultiPartFeature.class);
    }

    @Override
    protected URI getBaseUri() {
        return UriBuilder.fromUri("http://localhost:8080").path("betgroup-ws").build();
    }

    @Test
    public void testCreatePerson() {
        String input = "{\"name\":\"Jose\"}";

        WebTarget target = target().path("persons");
        Response response = target.request().post(Entity.entity(input, MediaType.APPLICATION_JSON));

        assertEquals(201, response.getStatus());

        System.out.println("Output received from web method createPerson ....");
        System.out.println("Person: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void testUpdatePerson() {
        String input = "{\"id\":\"1\",\"name\":\"Miguel\"}";

        WebTarget target = target().path("persons");
        Response response = target.request().put(Entity.entity(input, MediaType.APPLICATION_JSON));

        assertEquals(201, response.getStatus());

        System.out.println("Output received from web method updatePerson ....");
        System.out.println("Person: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void testGetPersonById() {
        WebTarget target = target().path("persons").path("1");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method getPersonById ....");
        System.out.println("person: " + response.readEntity(String.class));

        response.close();
    }

    @ApplicationPath("/")
    public class MyResourceConfig extends ResourceConfig {
        MyResourceConfig() {
            super(PersonResource.class, MultiPartFeature.class);
        }
    }
}
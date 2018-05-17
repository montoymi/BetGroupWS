package com.amadeus.betgroup;


import com.amadeus.betgroup.rest.account.UserResource;

import com.amadeus.betgroup.rest.config.ParamValueResource;
import com.amadeus.betgroup.service.config.ParamValueService;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.assertEquals;

public class UserTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new MyResourceConfig();
    }

    @Override
    protected void configureClient(ClientConfig config) {

    }

    @Override
    protected URI getBaseUri() {
        return UriBuilder.fromUri("http://localhost:8080").path("betgroup-ws").build();
    }


    @Test
    public void testValidateUser() {
        WebTarget target = target().path("users").queryParam("username", "Kcire").queryParam("password", "bacardi1");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method validateLogin ....");
        System.out.println("user: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void testGetCondTerms() {
        WebTarget target = target().path("params/terms").queryParam("lang", "es");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method getCondTerms ....");
        System.out.println("terms: " + response.readEntity(String.class));

        response.close();
    }

    @ApplicationPath("/")
    public class MyResourceConfig extends ResourceConfig {
        MyResourceConfig() {
            super(UserResource.class, ParamValueResource.class);
        }
    }
}
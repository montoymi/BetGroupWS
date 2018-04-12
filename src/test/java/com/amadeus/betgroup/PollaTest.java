package com.amadeus.betgroup;

import com.amadeus.betgroup.model.polla.PollaHeader;
import com.amadeus.betgroup.model.polla.PollaParticipant;
import com.amadeus.betgroup.rest.polla.PollaHeaderResource;
import com.amadeus.betgroup.rest.polla.PollaParticipantResource;
import org.glassfish.jersey.client.ClientConfig;
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

public class PollaTest extends JerseyTest {
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
    public void crearPolla() {
        /*
        accessFlag:true
        adminId:20
        costFlag:true
        password:"123456"
        pollaCost:"100"
        pollaName:"Polla Fio"
        templateHeaderId:1
        */

        String input = "{\"accessFlag\":0,\"adminId\":20,\"costFlag\":0,\"pollaName\":\"Polla Fio\",\"templateHeaderId\":1}";

        WebTarget target = target().path("pollas");
        Response response = target.request().post(Entity.entity(input, MediaType.APPLICATION_JSON));

        assertEquals(201, response.getStatus());

        System.out.println("Output received from web method crearPolla ....");
        System.out.println("Polla: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void getMisPollasByUserId() {
        WebTarget target = target().path("pollas").path("1");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method getMisPollasByUserId ....");
        System.out.println("pollaHeaderList: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void getParticipantListByPollaId() {
        WebTarget target = target().path("participants").path("3");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method getParticipantListByPollaId ....");
        System.out.println("pollaHeaderList: " + response.readEntity(String.class));

        response.close();
    }

    @Test
    public void validatePollaPassword() {
        /*PollaParticipantResource pollaParticipantResource = new PollaParticipantResource();
        PollaHeader pollaHeader = new PollaHeader();
        pollaHeader.setPollaId(48);
        pollaHeader.setPassword("1");
        pollaHeader.setAccessFlag(1);

        PollaParticipant pollaParticipant = new PollaParticipant();
        pollaParticipant.setPollaHeader(pollaHeader);
        pollaParticipantResource.inscribirUserInBetgroup(pollaParticipant);*/

        WebTarget target = target().path("participants");
        Response response = target.request(MediaType.APPLICATION_JSON).get();

        assertEquals(200, response.getStatus());

        System.out.println("Output received from web method test ....");
        System.out.println("test: " + response.readEntity(String.class));

        response.close();
    }


    @ApplicationPath("/")
    public class MyResourceConfig extends ResourceConfig {
        MyResourceConfig() {
            super(PollaHeaderResource.class, PollaParticipantResource.class);
        }
    }
}

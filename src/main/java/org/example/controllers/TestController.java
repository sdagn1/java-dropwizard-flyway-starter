package org.example.controllers;

import io.swagger.annotations.Api;
import org.example.services.TestService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Test API")
@Path("/api/test")
public class TestController {

    /**
     * Testing Service.
     */
    private TestService testService;

    /**
     * TestController initialization.
     * @param testService1
     */
    public TestController(final TestService testService1) {
        this.testService = testService1;
    }

    /**
     * Getter for TestService.
     * @return TestService object.
     */
    public TestService getTestService() {
        return testService;
    }

    /**
     * TestService Setter.
     * @param testService1
     */
    public void setTestService(final TestService testService1) {
        this.testService = testService1;
    }

    /**
     * Attempts to test the connection.
     * @return Response to indicate success or error.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testConnection() {
        try {
            return Response.ok().entity(testService.testConnection()).build();
        } catch (SQLException e) {
            return Response.serverError().build();
        }
    }
}

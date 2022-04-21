package com.example;

import com.example.user.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public UserDTO hello(UserDTO user) {
        return user;
    }
}
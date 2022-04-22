package com.example.user;

import com.example.user.dto.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService service;

    @GET
    public Response getAll() {
        return Response.ok(service.GetAll()).build();
    }

    @POST
    public boolean Add(UserDTO user){
        if(service.Add(user)){
            return true;
        }
        return false;
    }
}

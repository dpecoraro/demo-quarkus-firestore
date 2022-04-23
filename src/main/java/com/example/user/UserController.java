package com.example.user;

import com.example.user.dto.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    @Inject
    private UserService service;

    @GET
    public Response getAll() {
        return Response.ok(service.GetAll())
                .build();
    }

    @GET
    @Path("/email")
    public Response get(@QueryParam("email") String email){
        return Response.ok(service.getByEmail(email))
                .build();
    }

    @POST
    public boolean Add(UserDTO user){
        if(service.Add(user)){
            return true;
        }
        return false;
    }

    @POST
    @Path("/addUsers")
    public boolean AddUsers(List<UserDTO> users){
        service.AddPatchUsers(users);
        return true;
    }
}

package ferreira.quarkus.api.controller;

import ferreira.quarkus.infra.service.models.CreateUserCommand;
import ferreira.quarkus.infra.service.models.UpdateUserCommand;
import ferreira.quarkus.infra.service.UserService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("users")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GET
    public Response findAll(@QueryParam("page") @DefaultValue("0") Integer page, @QueryParam("pageSize") @DefaultValue("10") Integer pageSize)
    {
        var users = userService.findAll(page, pageSize);
        return Response.ok(users).build();
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") UUID userId)
    {
        var user = userService.find(userId);
        return Response.ok(user).build();
    }

    @POST
    public Response createUser(CreateUserCommand user)
    {
        var newUser = userService.createUser(user);
        return Response.ok(newUser).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") UUID userId, UpdateUserCommand user)
    {
        var newUser = userService.UpdateUser(userId, user);
        return Response.ok(newUser).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteUser(@PathParam("id") UUID userId)
    {
        userService.DeleteUser(userId);
        return Response.ok().build();
    }

}

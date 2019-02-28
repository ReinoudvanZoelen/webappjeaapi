package Resources;

import Controllers.UserController;
import Entities.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/users")
public class UserResource {

    @Inject
    UserController userController;

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("uuid") UUID uuid){
        return Response.ok()
                .entity(userController.getUser(uuid))
                .build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User createStudent(User user) {
        return userController.addUser(user);
    }
}

package Resources;

import Controllers.UserController;
import Entities.Player;

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
    public Response getUser(@PathParam("uuid") UUID uuid) {
        return Response.ok()
                .entity(userController.getByUUID(uuid))
                .build();
    }

    @GET
    @Path("/byAddress/{emailaddress}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("emailaddress") String emailaddress) {
        return Response.ok().entity(userController.getByEmailAddress(emailaddress)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Player createStudent(@FormParam("fullname") String fullname,
                                @FormParam("emailaddress") String emailaddress,
                                @FormParam("password") String password) {
        return userController.createUser(fullname, emailaddress, password);
    }
}

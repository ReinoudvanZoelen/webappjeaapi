package Resources;

import Controllers.PlayerController;
import Entities.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/players")
public class PlayerResource {

    @Inject
    PlayerController playerController;

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("uuid") UUID uuid) {
        return Response.ok()
                .entity(playerController.getByUUID(uuid))
                .build();
    }

    @GET
    @Path("/byAddress/{emailaddress}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("emailaddress") String emailaddress) {
        return Response.ok().entity(playerController.getByEmailAddress(emailaddress)).build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Player createPlayer(@FormParam("fullname") String fullname,
                                @FormParam("emailaddress") String emailaddress,
                                @FormParam("password") String password) {
        return playerController.createPlayer(fullname, emailaddress, password);
    }
}

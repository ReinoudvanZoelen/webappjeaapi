package Endpoints;

import BLL.Implementations.PlayerLogic;
import BLL.Interfaces.IPlayerLogic;
import Entities.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/players")
public class PlayerEndPoints {

    @Inject
    IPlayerLogic playerLogic;

    @GET
    @Path("/id/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("uuid") UUID uuid) {
        return Response.ok()
                .entity(playerLogic.getByUUID(uuid))
                .build();
    }

    @GET
    @Path("/emailaddress/{emailaddress}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPlayer(@PathParam("emailaddress") String emailaddress) {
        return Response.ok()
                .entity(playerLogic.getByEmailAddress(emailaddress))
                .build();
    }

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok()
                .entity(playerLogic.getAll())
                .build();
    }

    @POST
    @Path("")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlayer(@FormParam("fullname") String fullname,
                                @FormParam("emailaddress") String emailaddress,
                                @FormParam("password") String password) {
        Player newPlayer =  playerLogic.createPlayer(fullname, emailaddress, password);

        return Response.ok()
                .entity(newPlayer)
                .build();
    }
}

package Endpoints;

import BLL.Implementations.PlayerLogic;
import BLL.Interfaces.IPlayerLogic;
import Entities.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

@Path("/test")
public class TestingEndPoints {

    @GET
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok()
                .build();
    }
}

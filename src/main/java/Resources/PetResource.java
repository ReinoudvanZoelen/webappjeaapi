package Resources;

import Models.Pet;
import io.swagger.v3.oas.annotations.Parameter;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pet")
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {

    @GET
    @Path("/{petId}")
    public Pet getPetById(@PathParam("petId") Long petId) {
        // return pet
        Pet dog = new Pet();
        dog.setId(12345);
        dog.setName("Sulley the Shiber");
        return dog;
    }

    @POST
    @Consumes("application/json")
    public Response addPet(
            @Parameter(description = "Pet object that needs to be added to the store", required = true) Pet pet) {
        // add pet
        return Response.ok().entity("SUCCESS").build();
    }
}

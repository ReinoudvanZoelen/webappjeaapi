package Resources;

import Database.Implementations.Hibernate.AccountDALHibernate;
import Database.Implementations.Hibernate.UserDALHibernate;
import Entities.Account;
import Entities.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;


@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @GET
    @Path("/{accountId}")
    public Account getAccount(@PathParam("accountId") UUID accountId) {
        Account ac = new Account();
        ac.setEmailAddress("sulley@doggo.com");
        ac.setPassword("woofwoof123");

        return ac;
    }
}

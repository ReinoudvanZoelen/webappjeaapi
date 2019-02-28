package Resources;

import DAL.Implementations.Hibernate.AccountDALHibernate;
import DAL.Implementations.Hibernate.UserDALHibernate;
import DAL.Interfaces.IAccountDAL;
import DAL.Interfaces.IUserDAL;
import Models.Account;
import Models.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.apache.commons.lang3.time.DateUtils;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthorisationResource {
    private final static String secret = "reinoud";

    // Figure out where the DI is injected from when using @Inject
    IAccountDAL AccountDAL = new AccountDALHibernate();
    IUserDAL UserDAL = new UserDALHibernate();

    @POST
    @Path("/getToken")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getToken(
            @FormParam("emailAddress") String emailAddress,
            @FormParam("password") String password
    ) {
        if (emailAddress.isEmpty() || password.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Date startTime = new Date();

        Account account;
        User user;

        try {
            account = AccountDAL.getByLogin(emailAddress, password);
            user = UserDAL.GetByAccountId(account.getId());
        } catch (NoResultException exception) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        String jwt = Jwts.builder()
                .setIssuer("webappjeaapi")
                .setSubject("emailAddress")
                .claim("name", user.getFullName())
                .setIssuedAt(startTime)
                .setExpiration(DateUtils.addHours(startTime, 1))
                .signWith(
                        SignatureAlgorithm.HS256,
                        TextCodec.BASE64.decode(AuthorisationResource.secret)
                )
                .compact();

        return Response.ok(jwt, MediaType.APPLICATION_JSON).status(Response.Status.OK).build();
    }
}

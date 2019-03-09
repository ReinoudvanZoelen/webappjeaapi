package Controllers;

import Database.Implementations.Hibernate.PlayerDALHibernate;
import Entities.Player;

import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class UserController {

    // TODO: @Inject
    private PlayerDALHibernate userJPA = new PlayerDALHibernate();

    public Player createUser(String fullname, String emailaddress, String password)
    {
        Player newuser = new Player();
        newuser.setFullName(fullname);
        newuser.setEmailAddress(emailaddress);
        newuser.setPassword(password);

        Player player = userJPA.Create(newuser);
        return player;
    }

    public Player getByEmailAddress(String emailAddress){
        return userJPA.GetByEmailAddress(emailAddress);
    }

    public Player getByUUID(UUID uuid) {
        return userJPA.GetById(uuid);
    }
}

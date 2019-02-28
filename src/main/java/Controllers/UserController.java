package Controllers;

import Database.Implementations.Hibernate.UserDALHibernate;
import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class UserController {

    // TODO: @Inject
    private UserDALHibernate userJPA = new UserDALHibernate();

    public User createUser(String fullname, String emailaddress, String password)
    {
        // TODO: Generate salt
        String salt = "reinoud";

        // TODO: Hash password
        String hashedPassword = password + salt;

        User newuser = new User();
        newuser.setFullName(fullname);
        newuser.setEmailAddress(emailaddress);
        newuser.setHashedPassword(hashedPassword);
        newuser.setSalt(salt);

        User user = userJPA.Create(newuser);
        return user;
    }

    public User getByEmailAddress(String emailAddress){
        return userJPA.GetByEmailAddress(emailAddress);
    }

    public User getByUUID(UUID uuid) {
        return userJPA.GetById(uuid);
    }
}

package Controllers;

import Database.Implementations.Hibernate.UserDALHibernate;
import Entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.UUID;

@ApplicationScoped
public class UserController {

    @Inject
    private UserDALHibernate userJPA;

    public User addUser(User user) {
        return userJPA.Create(user);
    }

    public Object getUser(UUID uuid) {
        return userJPA.GetById(uuid);
    }
}

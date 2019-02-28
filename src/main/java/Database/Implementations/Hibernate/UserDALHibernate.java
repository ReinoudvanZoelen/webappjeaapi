package Database.Implementations.Hibernate;

import Database.Interfaces.IUserDAL;
import Entities.User;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.UUID;

public class UserDALHibernate implements IUserDAL {

    @PersistenceContext(unitName = "CloverCoatPU")
    private EntityManager entityManager;

    @Resource
    private UserTransaction transaction;

    @Override
    public User GetById(UUID uuid) {
        return entityManager.find(User.class, uuid);
    }

    @Override
    public List<User> GetAll() {
        List<User> users = null;
        try {
            users = entityManager.createQuery("SELECT s FROM User s", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    @Override
    public User Create(User model) {
        try {
            transaction.begin();
            entityManager.persist(model);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return model;
        }
    }

    @Override
    public User Update(User model) {
        User userToUpdate = entityManager.find(User.class, model.getId());

        try {
            transaction.begin();
            userToUpdate.setFirstName(model.getFirstName());
            userToUpdate.setLastName(model.getLastName());
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return userToUpdate;
        }
    }

    @Override
    public boolean Delete(UUID id) {
        try {
            transaction.begin();
            User userToDelete = entityManager.find(User.class, id);
            entityManager.remove(entityManager.contains(userToDelete) ?
                    userToDelete : entityManager.merge(userToDelete));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            return true;
        }
    }
}

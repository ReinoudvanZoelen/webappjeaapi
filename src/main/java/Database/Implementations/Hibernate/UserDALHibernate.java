package Database.Implementations.Hibernate;

import Database.Interfaces.IUserDAL;
import Entities.User;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class UserDALHibernate implements IUserDAL {

    //@PersistenceContext(unitName = "CloverCoatPU")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CloverCoatPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Resource
    private EntityTransaction transaction;

    @Override
    public User GetById(UUID uuid) {
        return entityManager.find(User.class, uuid);
    }

    @Override
    public User GetByEmailAddress(String emailAddress) {
        String query = "SELECT user FROM User user WHERE user.EmailAddress = '" + emailAddress + "'";
        User user = entityManager.createQuery(query, User.class).getSingleResult();

        return user;
    }

    @Override
    public List<User> GetAll() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public User Create(User model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();

        return model;
    }

    @Override
    public User Update(User model) {
        try {
            transaction.begin();
            entityManager.persist(model);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return model;
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
        }

        return true;
    }
}

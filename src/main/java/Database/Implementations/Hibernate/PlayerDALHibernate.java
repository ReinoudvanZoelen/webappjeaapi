package Database.Implementations.Hibernate;

import Database.Interfaces.IPlayerDAL;
import Entities.Player;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PlayerDALHibernate implements IPlayerDAL {

    //@PersistenceContext(unitName = "CloverCoatPU")
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("CloverCoatPU");
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Resource
    private EntityTransaction transaction;

    @Override
    public Player GetById(UUID uuid) {
        return entityManager.find(Player.class, uuid);
    }

    @Override
    public Player GetByEmailAddress(String emailAddress) {
        String query = "SELECT user FROM Player user WHERE user.EmailAddress = '" + emailAddress + "'";
        Player player = entityManager.createQuery(query, Player.class).getSingleResult();

        return player;
    }

    @Override
    public List<Player> GetAll() {
        return entityManager.createQuery("SELECT user FROM Player user", Player.class).getResultList();
    }

    @Override
    public Player Create(Player model) {
        entityManager.getTransaction().begin();
        entityManager.persist(model);
        entityManager.getTransaction().commit();

        return model;
    }

    @Override
    public Player Update(Player model) {
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
            Player playerToDelete = entityManager.find(Player.class, id);
            entityManager.remove(entityManager.contains(playerToDelete) ?
                    playerToDelete : entityManager.merge(playerToDelete));
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

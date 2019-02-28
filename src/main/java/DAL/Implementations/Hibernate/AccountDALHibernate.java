package DAL.Implementations.Hibernate;

import DAL.Interfaces.IAccountDAL;
import Models.Account;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class AccountDALHibernate implements IAccountDAL {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

    @Override
    public Account GetById(UUID Id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Account account = entityManager.getReference(Account.class, Id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return account;
    }

    @Override
    public List<Account> GetAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Account> accounts = entityManager.createQuery("SELECT a FROM Account a", Account.class).getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return accounts;
    }

    @Override
    public void Update(Account model) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(model);

        entityManager.close();
    }

    @Override
    public boolean Delete(UUID id) {
        return false;
    }

    @Override
    public Account getByLogin(String emailAddress, String password) {
        Account a = new Account();
        a.setEmailAddress("reinoudvanzoelen@gmail.com");
        a.setPassword("pokemon1234");
        return a;
    }
}

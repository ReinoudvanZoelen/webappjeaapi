package DAL.Implementations.Hibernate;

import DAL.Interfaces.IAccountDAL;
import Models.Account;

import java.util.List;
import java.util.UUID;

public class AccountDALHibernate implements IAccountDAL {
    @Override
    public Account GetById(UUID Id) {
        return null;
    }

    @Override
    public List<Account> GetAll() {
        return null;
    }

    @Override
    public Account Update(Account model) {
        return null;
    }

    @Override
    public boolean Delete(UUID id) {
        return false;
    }

    @Override
    public Account getByLogin(String emailAddress, String password) {
        return null;
    }
}

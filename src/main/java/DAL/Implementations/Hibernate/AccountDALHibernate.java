package DAL.Implementations;

import DAL.Interfaces.IAccountDAL;
import Models.Account;

import java.util.UUID;

public class AccountDALHibernate implements IAccountDAL {
    @Override
    public Account GetById(UUID Id) {
        return null;
    }

    @Override
    public Account getByLogin(String emailAddress, String password) {
        return null;
    }
}

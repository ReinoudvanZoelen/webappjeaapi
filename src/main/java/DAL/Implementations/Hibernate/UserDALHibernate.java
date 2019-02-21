package DAL.Implementations;

import DAL.Interfaces.IUserDAL;
import Models.User;

import java.util.UUID;

public class UserDALHibernate implements IUserDAL {
    @Override
    public User GetById(UUID Id) {
        return null;
    }

    @Override
    public User GetByAccountId(UUID Id) {
        return null;
    }
}

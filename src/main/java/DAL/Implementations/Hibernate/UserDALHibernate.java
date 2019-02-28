package DAL.Implementations.Hibernate;

import DAL.Interfaces.IUserDAL;
import Models.User;

import java.util.List;
import java.util.UUID;

public class UserDALHibernate implements IUserDAL {
    @Override
    public User GetById(UUID Id) {
        return null;
    }

    @Override
    public List<User> GetAll() {
        return null;
    }

    @Override
    public void Update(User model) { }

    @Override
    public boolean Delete(UUID id) {
        return false;
    }

    @Override
    public User GetByAccountId(UUID Id) {
        return null;
    }
}

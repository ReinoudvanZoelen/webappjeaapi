package DAL.Interfaces;

import Models.User;

import java.util.UUID;

public interface IUserDAL extends IDALBase<User> {
    User GetByAccountId(UUID Id);
}

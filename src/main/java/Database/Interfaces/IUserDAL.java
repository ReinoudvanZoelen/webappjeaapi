package Database.Interfaces;

import Entities.User;

public interface IUserDAL extends IDALBase<User> {
    User GetByEmailAddress(String emailAddress);
}

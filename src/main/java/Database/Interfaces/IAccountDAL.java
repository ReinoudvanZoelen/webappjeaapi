package Database.Interfaces;

import Entities.Account;

public interface IAccountDAL extends IDALBase<Account> {
    Account getByLogin(String emailAddress, String password);
}

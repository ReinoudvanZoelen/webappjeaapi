package DAL.Interfaces;

import Models.Account;

public interface IAccountDAL extends IDALBase<Account> {
    Account getByLogin(String emailAddress, String password);
}

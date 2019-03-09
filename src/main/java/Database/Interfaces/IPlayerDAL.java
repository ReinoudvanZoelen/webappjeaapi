package Database.Interfaces;

import Entities.Player;

public interface IPlayerDAL extends IDALBase<Player> {
    Player GetByEmailAddress(String emailAddress);
}

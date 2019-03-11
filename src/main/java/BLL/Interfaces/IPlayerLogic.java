package BLL.Interfaces;

import Entities.Player;

import java.util.List;
import java.util.UUID;

public interface IPlayerLogic {
    Player createPlayer(String fullname, String emailaddress, String password);

    List<Player> getAll();

    Player getByEmailAddress(String emailAddress);

    Player getByUUID(UUID uuid) ;
}

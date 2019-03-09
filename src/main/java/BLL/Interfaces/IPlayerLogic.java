package BLL.Interfaces;

import Entities.Player;

import java.util.UUID;

public interface IPlayerLogic {
    Player createPlayer(String fullname, String emailaddress, String password);

    Player getByEmailAddress(String emailAddress);

    Player getByUUID(UUID uuid) ;
}

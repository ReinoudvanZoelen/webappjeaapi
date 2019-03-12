package BLL.Implementations;

import BLL.Interfaces.IPlayerLogic;
import DAL.Implementations.Hibernate.PlayerDALHibernate;
import DAL.Interfaces.IPlayerDAL;
import Entities.Player;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PlayerLogic implements IPlayerLogic {

    private IPlayerDAL playerDAL;

    // Default DAL
    public PlayerLogic() {
        this.playerDAL = new PlayerDALHibernate();
    }

    // Override default DAL
    public PlayerLogic(IPlayerDAL playerDAL) {
        this.playerDAL = playerDAL;
    }

    public Player createPlayer(String fullname, String emailaddress, String password)
    {
        Player newPlayer = new Player();
        newPlayer.setFullName(fullname);
        newPlayer.setEmailAddress(emailaddress);
        newPlayer.setPassword(password);

        Player player = playerDAL.Create(newPlayer);
        return player;
    }

    @Override
    public List<Player> getAll() {
        return playerDAL.GetAll();
    }

    public Player getByEmailAddress(String emailAddress){
        return playerDAL.GetByEmailAddress(emailAddress);
    }

    public Player getByUUID(UUID uuid) {
        return playerDAL.GetById(uuid);
    }
}

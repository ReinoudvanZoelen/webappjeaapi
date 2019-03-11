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

    // TODO: @Inject
    private IPlayerDAL playerJPA = new PlayerDALHibernate();

    public Player createPlayer(String fullname, String emailaddress, String password)
    {
        Player newPlayer = new Player();
        newPlayer.setFullName(fullname);
        newPlayer.setEmailAddress(emailaddress);
        newPlayer.setPassword(password);

        Player player = playerJPA.Create(newPlayer);
        return player;
    }

    @Override
    public List<Player> getAll() {
        return playerJPA.GetAll();
    }

    public Player getByEmailAddress(String emailAddress){
        return playerJPA.GetByEmailAddress(emailAddress);
    }

    public Player getByUUID(UUID uuid) {
        return playerJPA.GetById(uuid);
    }
}

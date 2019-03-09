package DAL.Implementations.Mock;

import DAL.Interfaces.IPlayerDAL;
import Entities.Player;

import java.util.List;
import java.util.UUID;

public class PlayerDALMock implements IPlayerDAL {
    @Override
    public Player GetByEmailAddress(String emailAddress) {
        return null;
    }

    @Override
    public Player GetById(UUID uuid) {
        return null;
    }

    @Override
    public List<Player> GetAll() {
        return null;
    }

    @Override
    public Player Create(Player model) {
        return null;
    }

    @Override
    public Player Update(Player model) {
        return null;
    }

    @Override
    public boolean Delete(UUID id) {
        return false;
    }
}

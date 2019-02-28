package Database.Interfaces;

import java.util.List;
import java.util.UUID;

public interface IDALBase<T> {
    T GetById(UUID uuid);
    List<T> GetAll();
    T Create(T model);
    T Update(T model);
    boolean Delete(UUID id);
}

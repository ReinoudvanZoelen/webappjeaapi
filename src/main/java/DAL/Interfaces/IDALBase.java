package DAL.Interfaces;

import java.util.List;
import java.util.UUID;

public interface IDALBase<T> {
    T GetById(UUID uuid);
    List<T> GetAll();
    void Update(T model);
    boolean Delete(UUID id);
}

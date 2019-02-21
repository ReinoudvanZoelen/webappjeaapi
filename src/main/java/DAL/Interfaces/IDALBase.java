package DAL.Interfaces;

import java.util.List;
import java.util.UUID;

public interface IDALBase<T> {
    public T GetById(UUID uuid);
    public List<T> GetAll();
    public T Update(T model);
    public boolean Delete(UUID id);
}

package products.db;

import java.util.List;

public interface DBInterface<T> {
    public String insert(T dto);
    public T getOne(String id) throws Exception;
    public List<T> getAll();
    public T update(String id, Object dto) throws Exception;
    public String delete(String id) throws Exception;
}

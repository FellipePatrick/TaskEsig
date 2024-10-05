package projeto.esig.crud.service;

import java.util.List;

public interface IService<T, ID> {
    public void deleteById(ID id);
    public List<T> findAll();
    public T findById(ID id);
    public T create(T entity);
    public T update(T entity, ID id);
}

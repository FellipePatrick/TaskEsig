package projeto.esig.crud.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

public abstract class GenericService<T, ID, REPO extends JpaRepository<T, ID>> implements IService<T, ID> {

    private REPO repository;

    public GenericService(REPO repository) {
        this.repository = repository;
    }

    @Override
    public void deleteById(ID id) {
        Optional<T> entity = repository.findById(id);

        if (!entity.isPresent()) {
            throw new EntityNotFoundException("Objeto de id " + id + "not found");
        }
        
        this.repository.delete(entity.get());
    }

    public Page<T> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public T findById(ID id) {
        Optional<T> optional = this.repository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }

        throw new EntityNotFoundException("Objeto de id" + id + "not found");
    }

    @Override
    public T create(T entity) {
        return this.repository.save(entity);
    }

    @Override
    public T update(T entity, ID id) {
        return this.repository.saveAndFlush(entity);
    }
}
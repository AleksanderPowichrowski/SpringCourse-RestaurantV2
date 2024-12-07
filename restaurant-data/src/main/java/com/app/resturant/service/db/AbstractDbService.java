package com.app.resturant.service.db;

import com.app.resturant.service.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Set;


public abstract class AbstractDbService<T, ID,R extends  CrudRepository<T, ID>> implements CrudService<T, ID> {

    protected R repository;

    public AbstractDbService(R repository) {
        this.repository = repository;
    }

    @Override
    public Set<T> findAll() {
        Set<T> entitySet = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(entitySet::add);
        return entitySet;
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElse(null);
    }

    public <S extends T> void saveAll(Iterable<S> entities){
        repository.saveAll(entities);
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(ID aLong) {
        repository.deleteById(aLong);
    }
}

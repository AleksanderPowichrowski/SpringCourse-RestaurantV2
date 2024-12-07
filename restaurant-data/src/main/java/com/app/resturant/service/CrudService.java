package com.app.resturant.service;

import javax.naming.OperationNotSupportedException;
import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object) throws OperationNotSupportedException;

    void deleteById(ID id);
}

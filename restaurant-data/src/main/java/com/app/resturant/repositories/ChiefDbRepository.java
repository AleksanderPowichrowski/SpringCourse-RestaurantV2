package com.app.resturant.repositories;

import com.app.resturant.model.Chief;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiefDbRepository extends CrudRepository<Chief,Long> {
}

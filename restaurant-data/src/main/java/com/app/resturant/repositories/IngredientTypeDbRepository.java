package com.app.resturant.repositories;

import com.app.resturant.model.IngredientType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientTypeDbRepository extends CrudRepository<IngredientType,Long> {

}

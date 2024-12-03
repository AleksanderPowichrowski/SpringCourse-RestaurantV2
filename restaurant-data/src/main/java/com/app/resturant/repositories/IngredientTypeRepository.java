package com.app.resturant.repositories;

import com.app.resturant.model.IngredientType;
import org.springframework.data.repository.CrudRepository;

import java.util.HashMap;

public interface IngredientTypeRepository  extends CrudRepository<IngredientType,Long> {
    HashMap<IngredientType,Long> findByName(IngredientType ingredientType);
}

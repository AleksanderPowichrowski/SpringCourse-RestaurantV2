package com.app.resturant.repositories;

import com.app.resturant.model.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeDbRepository extends CrudRepository<Recipe,Long> {
}

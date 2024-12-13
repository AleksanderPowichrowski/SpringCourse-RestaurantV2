package com.app.resturant.repositories;

import com.app.resturant.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishDbRepository extends CrudRepository<Dish,Long> {
}

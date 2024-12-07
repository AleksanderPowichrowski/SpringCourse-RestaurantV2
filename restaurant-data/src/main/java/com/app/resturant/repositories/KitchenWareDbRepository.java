package com.app.resturant.repositories;

import com.app.resturant.model.KitchenWare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KitchenWareDbRepository extends CrudRepository<KitchenWare, Long> {
    Optional<KitchenWare> findByName(String string);
}

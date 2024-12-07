package com.app.resturant.repositories;

import com.app.resturant.model.UnitMeasure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitMeasureDbRepository extends CrudRepository<UnitMeasure, Long> {



}

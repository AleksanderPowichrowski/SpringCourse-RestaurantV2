package com.app.resturant.repositories;

import com.app.resturant.model.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockDbRepository extends CrudRepository<Stock, Long> {


}

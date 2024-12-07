package com.app.resturant.service.map;

import com.app.resturant.model.Stock;

import java.util.Set;

public class StockMapService extends AbstractMapService<Stock,Long>{

    @Override
    public Set<Stock> findAll() {
        return super.findAll();
    }

    @Override
    public Stock findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Stock save(Stock object) {
        return super.save(object);
    }

    @Override
    public void delete(Stock object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

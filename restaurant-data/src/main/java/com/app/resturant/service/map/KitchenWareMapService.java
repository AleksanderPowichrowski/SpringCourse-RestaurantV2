package com.app.resturant.service.map;

import com.app.resturant.model.KitchenWare;

import java.util.Set;

public class KitchenWareMapService extends AbstractMapService<KitchenWare,Long>{
    @Override
    public Set<KitchenWare> findAll() {
        return super.findAll();
    }

    @Override
    public KitchenWare findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public KitchenWare save(KitchenWare object) {
        if(map.values().stream().anyMatch( x -> x.getName().equalsIgnoreCase(object.getName())))
            throw new RuntimeException("KitchenWare: " + object.getName() + " already exists");
        return super.save(object);
    }

    @Override
    public void delete(KitchenWare object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

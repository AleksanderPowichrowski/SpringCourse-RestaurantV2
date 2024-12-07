package com.app.resturant.service.map;

import com.app.resturant.model.IngredientType;

import java.util.Set;

public class IngredientTypeMapService extends AbstractMapService<IngredientType,Long>{
    @Override
    public Set<IngredientType> findAll() {
        return super.findAll();
    }

    @Override
    public IngredientType findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public IngredientType save(IngredientType object) {
        if(map.values().stream().anyMatch( x -> x.getName().equalsIgnoreCase(object.getName())))
            throw new RuntimeException("Ingredient Type: " + object.getName() + " already exists");
        return super.save(object);
    }

    @Override
    public void delete(IngredientType object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

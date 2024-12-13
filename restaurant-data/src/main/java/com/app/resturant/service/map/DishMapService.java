package com.app.resturant.service.map;

import com.app.resturant.model.Dish;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DishMapService extends AbstractMapService<Dish,Long>{

    public Dish findByName(String name){
        for(var entry : map.entrySet()){
            String entryName = entry.getValue().getName();
            if(entryName.equalsIgnoreCase(name))
                return entry.getValue();
        }
        throw new RuntimeException("There is no such dish with name: " + name);
    }

    @Override
    public Set<Dish> findAll() {
        return super.findAll();
    }

    @Override
    public Dish findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Dish save(Dish object) {
        return super.save(object);
    }

    @Override
    public void delete(Dish object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }
}

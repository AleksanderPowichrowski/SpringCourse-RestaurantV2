package com.app.resturant.service.map;

import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.IngredientType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;


class IngredientTypeMapServiceTest extends BasicRestaurantTest {
    IngredientTypeMapService mapService;

    @BeforeEach
    public void startUpIngrerdientTypeTests(){
        mapService = new IngredientTypeMapService();
    }



    @Test
    void findAll() {
        mapService.save(beef);
        Set<IngredientType> ingredientTypeSet = mapService.findAll();
        Assertions.assertEquals(1,ingredientTypeSet.size());
    }

    @Test
    void findById() {
        mapService.save(beef);
        IngredientType ingredientType = mapService.findById(1l);
        Assertions.assertEquals(1,ingredientType.getId());
    }

    @Test
    void save() {
       IngredientType savedIngredientType =  mapService.save(beef);
        Assertions.assertEquals(savedIngredientType,beef);
    }

    @Test
    void delete() {
        mapService.save(beef);
        mapService.delete(beef);
        Set<IngredientType> ingredientTypeSet = mapService.findAll();
        Assertions.assertEquals(0,ingredientTypeSet.size());
    }

    @Test
    void deleteById() {
        mapService.save(beef);
        mapService.deleteById(1l);
        Assertions.assertEquals(0,mapService.findAll().size());
    }

    @Test
    void findByName() {
        mapService.save(beef);
        IngredientType ingredientType = mapService.findByName("BEEF");
        Assertions.assertEquals("BEEF",ingredientType.getName());
    }

}
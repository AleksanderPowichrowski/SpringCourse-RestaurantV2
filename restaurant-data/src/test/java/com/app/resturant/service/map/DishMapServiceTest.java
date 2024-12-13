package com.app.resturant.service.map;

import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.Dish;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

class DishMapServiceTest extends BasicRestaurantTest {

    DishMapService dishMapService;

    @BeforeEach
    void setUp() {
        dishMapService = new DishMapService();
    }

    @Test
    void findAll() {
        dishMapService.save(friefBeefVegetablesDish);
        Set<Dish> dishSet = dishMapService.findAll();
        Assertions.assertEquals(1,dishSet.size());
    }

    @Test
    void findById() {
        dishMapService.save(friefBeefVegetablesDish);
        Dish dish = dishMapService.findById(1l);
        Assertions.assertEquals(1,dish.getId());
    }

    @Test
    void save() {
        Dish savedDish =  dishMapService.save(friefBeefVegetablesDish);
        Assertions.assertEquals(savedDish,friefBeefVegetablesDish);
    }

    @Test
    void delete() {
        dishMapService.save(friefBeefVegetablesDish);
        dishMapService.delete(friefBeefVegetablesDish);
        Set<Dish> dishSet = dishMapService.findAll();
        Assertions.assertEquals(0,dishSet.size());
    }

    @Test
    void deleteById() {
        dishMapService.save(friefBeefVegetablesDish);
        dishMapService.deleteById(1l);
        Assertions.assertEquals(0,dishMapService.findAll().size());
    }

    @Test
    void findByName() {
        dishMapService.save(friefBeefVegetablesDish);
        Dish dish = dishMapService.findByName("Fried beef with sliced vegetables");
        Assertions.assertEquals("Fried beef with sliced vegetables",dish.getName());
    }
}
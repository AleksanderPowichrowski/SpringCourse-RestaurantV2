package com.app.resturant.repositories;

import com.app.restaurant.web.RestaurantWebApplication;
import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.Dish;
import com.app.resturant.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Set;

@SpringBootTest(classes = RestaurantWebApplication.class)
@Profile("db")
@RunWith(SpringRunner.class)
class OrderDbRepositoryTest extends BasicRestaurantTest {

    @Autowired
    OrderDbRepository orderDbRepository;
    @Autowired
    DishDbRepository dishDbRepository;


    @BeforeEach
    void setUp() {

    }

    @Test
    void getByDateNow() {
        Dish dish1 = dishDbRepository.save(vegetableSaladDish);
        Dish dish2 = dishDbRepository.save(friedChickenVegetablesDish);
        Dish dish3 = dishDbRepository.save(friefBeefVegetablesDish);



        Order order = orderDbRepository.save(createOrderNow(dish1,dish2,dish3));
        Set<Order> orderSet= orderDbRepository.getByDate(LocalDate.now());
        Assertions.assertEquals(1,orderSet.size());
    }
    @Test
    void getByDatePast() {
        Dish dish1 = dishDbRepository.save(vegetableSaladDish);
        Dish dish2 = dishDbRepository.save(friedChickenVegetablesDish);
        Dish dish3 = dishDbRepository.save(friefBeefVegetablesDish);



        Order order = orderDbRepository.save(createOrderNow(dish1,dish2,dish3));
        Set<Order> orderSet= orderDbRepository.getByDate(LocalDate.now().minusDays(3));
        Assertions.assertEquals(0,orderSet.size());
    }
    @Test
    void getByDateFuture() {
        Dish dish1 = dishDbRepository.save(vegetableSaladDish);
        Dish dish2 = dishDbRepository.save(friedChickenVegetablesDish);
        Dish dish3 = dishDbRepository.save(friefBeefVegetablesDish);

        orderDbRepository.save(createOrderNow(dish1,dish2,dish3));
        Set<Order> orderSet= orderDbRepository.getByDate(LocalDate.now().plusDays(3));
        Assertions.assertEquals(0,orderSet.size());
    }
}
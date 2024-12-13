package com.app.resturant.service.map;

import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

class OrderMapServiceTest extends BasicRestaurantTest {

    OrderMapService orderMapService;

    @BeforeEach
    void setUp() {
        orderMapService = new OrderMapService();
    }

    @Test
    void findAll() {
        orderMapService.save(orderNow);
        Set<Order> dishSet = orderMapService.findAll();
        Assertions.assertEquals(1,dishSet.size());
    }

    @Test
    void findById() {
        orderMapService.save(orderNow);
        Order order = orderMapService.findById(1l);
        Assertions.assertEquals(1,order.getId());
    }

    @Test
    void save() {
        Order order =  orderMapService.save(orderNow);
        Assertions.assertEquals(order,orderNow);
    }

    @Test
    void delete() {
        orderMapService.save(orderNow);
        orderMapService.delete(orderNow);
        Set<Order> dishSet = orderMapService.findAll();
        Assertions.assertEquals(0,dishSet.size());
    }

    @Test
    void deleteById() {
        orderMapService.save(orderNow);
        orderMapService.deleteById(1l);
        Assertions.assertEquals(0,orderMapService.findAll().size());
    }

    @Test
    void getOrderByDateNow() {
        LocalDate testDate = LocalDate.now();
        orderMapService.save(orderNow);
        Set<Order> orderSet = orderMapService.getOrderByDate(testDate);

        Assertions.assertEquals(1,orderSet.size());

    }
    @Test
    void getOrderByDateOld() {
        LocalDate testDate = LocalDate.now();
        orderMapService.save(orderOld);
        Set<Order> orderSet = orderMapService.getOrderByDate(testDate);

        Assertions.assertEquals(0,orderSet.size());

    }
    @Test
    void getOrderByDateFuture() {
        LocalDate testDate = LocalDate.now();
        orderMapService.save(orderFuture);
        Set<Order> orderSet = orderMapService.getOrderByDate(testDate);

        Assertions.assertEquals(0,orderSet.size());

    }
}
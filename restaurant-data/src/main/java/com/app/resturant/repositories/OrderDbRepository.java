package com.app.resturant.repositories;

import com.app.resturant.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Repository
public interface OrderDbRepository extends CrudRepository<Order,Long> {

    default Set<Order> getByDate(LocalDate date){
        Iterator<Order> orderIterator =  findAll().iterator();
        Set<Order> orderSet = new HashSet<>();
            while(orderIterator.hasNext()){
                Order order = orderIterator.next();
                if( order.getOrderDateTime().isAfter(LocalDateTime.of(date, LocalTime.MIN)) &&  order.getOrderDateTime().isBefore(LocalDateTime.of(date, LocalTime.MAX)))
                        orderSet.add(order);
            }

            return   orderSet;
    }
}

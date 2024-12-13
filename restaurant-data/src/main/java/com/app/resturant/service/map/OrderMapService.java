package com.app.resturant.service.map;

import com.app.resturant.model.Order;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class OrderMapService extends AbstractMapService<Order, Long> {

    @Override
    public Set<Order> findAll() {
        return super.findAll();
    }

    @Override
    public Order findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Order save(Order object) {
        return super.save(object);
    }

    @Override
    public void delete(Order object) {
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

    public Set<Order> getOrderByDate(LocalDate dateTime) {
        return findAll().stream()
                .filter(order -> order.getOrderDateTime().isAfter(LocalDateTime.of(dateTime, LocalTime.MIN)))
                .filter(order -> order.getOrderDateTime().isBefore(LocalDateTime.of(dateTime, LocalTime.MAX)))
                .collect(Collectors.toSet());
    }
}

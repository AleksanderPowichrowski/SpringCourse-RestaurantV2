package com.app.resturant.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseEntity{

    @Column(name = "summed_cost", precision = 10, scale = 2)
    private BigDecimal summedCost = BigDecimal.ZERO;

    @OneToMany
    @JoinTable(
            name = "order_dishes",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id")
    )
    private List<Dish> dishes;

    @Column(name="order_datetime")
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH-mm")
    private LocalDateTime orderDateTime;

    @Builder
    public Order(List<Dish> dishes,LocalDateTime orderDateTime) {
        this.dishes = dishes;
        this.orderDateTime = orderDateTime;
        this.summedCost = this.dishes.stream()
                .map(Dish::getCost)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;

        // Compare dish names in one stream operation
        boolean areDishNamesSame = this.dishes.stream()
                .map(Dish::getName)
                .collect(Collectors.toSet())
                .equals(order.dishes.stream()
                        .map(Dish::getName)
                        .collect(Collectors.toSet()));

        return Objects.equals(summedCost, order.summedCost) &&
                areDishNamesSame &&
                Objects.equals(orderDateTime, order.orderDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), summedCost, dishes, orderDateTime);
    }
}

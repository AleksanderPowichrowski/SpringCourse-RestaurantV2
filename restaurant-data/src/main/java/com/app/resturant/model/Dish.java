package com.app.resturant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Data
@Table(name = "dish")
public class Dish extends NamedBaseEntity{


    @Column(name = "cost", precision = 10, scale = 2)
    BigDecimal cost;
    public Dish(Recipe recipe, BigDecimal cost) {
        super(recipe.getName());
        this.cost = cost;
    }
    @Builder
    public Dish(String name, BigDecimal cost) {
        super(name);
        this.cost = cost;
    }

    public void setCost(BigDecimal cost) {
        if (cost != null) {
            this.cost = cost.setScale(2, RoundingMode.HALF_UP); // Ensure two decimal places
        } else {
            this.cost = null;
        }
    }



}

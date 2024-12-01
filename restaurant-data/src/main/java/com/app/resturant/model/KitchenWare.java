package com.app.resturant.model;

import jakarta.persistence.Table;
import lombok.*;

@Table(name = "kitchen_ware")
@ToString
@Getter
@Setter
public class KitchenWare extends BaseEntity{
    private String name;

    @Builder
    public KitchenWare(String name){
        this.name = name;
    }
}

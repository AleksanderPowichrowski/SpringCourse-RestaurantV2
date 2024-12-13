package com.app.resturant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Table(name = "kitchen_ware")
@Data
@Entity
@NoArgsConstructor
public class KitchenWare extends NamedBaseEntity{

    @Builder
    public KitchenWare(String name){
       super(name);
    }
}

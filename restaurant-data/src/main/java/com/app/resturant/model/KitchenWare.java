package com.app.resturant.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

package com.app.resturant.model;


import jakarta.persistence.*;
import lombok.*;



@EqualsAndHashCode(callSuper = true)
@Table(name = "types")
@Entity
@NoArgsConstructor
@Data
public class IngredientType extends NamedBaseEntity {

    @Column(name = "vegan")
    private boolean isVegan;

    @Builder
    public IngredientType(String name, boolean isVegan) {
       super(name);
        this.isVegan = isVegan;
    }
}

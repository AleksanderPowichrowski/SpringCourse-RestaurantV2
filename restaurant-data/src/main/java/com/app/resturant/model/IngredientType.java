package com.app.resturant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



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

package com.app.resturant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;



@Table(name = "types")
@ToString
@NoArgsConstructor
@Setter
@Getter
public class IngredientType extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "vegan")
    private boolean isVegan;

    @Builder
    public IngredientType(String name, boolean isVegan) {
        this.name=name;
        this.isVegan = isVegan;
    }
}

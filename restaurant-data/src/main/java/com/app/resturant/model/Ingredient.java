package com.app.resturant.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;



@AllArgsConstructor
@ToString
@Embeddable
@NoArgsConstructor
@Builder
@Data
public class Ingredient {
    @ManyToOne
    @JoinColumn(name = "type_id")
    private IngredientType ingredientType;
    @ManyToOne
    @JoinColumn(name = "unit_id")
    private UnitMeasure unitMeasure;
}

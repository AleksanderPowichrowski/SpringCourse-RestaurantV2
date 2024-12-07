package com.app.resturant.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Table(name = "recipes")
@Data
@Entity
@NoArgsConstructor
public class Recipe extends NamedBaseEntity {

    @ManyToMany
    @JoinTable(
            name = "recipe_needed_kitchenware",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "kitchenware_id")
    )
    List<KitchenWare> neededKitchenWare;

    @Transient
    Map<Long, String> instructions;
    @ElementCollection
    @CollectionTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id")
    )
    @MapKeyJoinColumns({
            @MapKeyJoinColumn(name = "type_id", referencedColumnName = "id"),
            @MapKeyJoinColumn(name = "unit_id", referencedColumnName = "id")
    })
    @Column(name = "quantity")
    Map<Ingredient, Long> neededIngredients;
    @Column(name = "instructions_string")
    private String instructionsString;

    @Builder
    public Recipe(String name, Map<Ingredient, Long> neededIngredients, List<KitchenWare> neededKitchenWare, Map<Long, String> instructions) {
        super(name);
        this.neededIngredients = neededIngredients;
        this.neededKitchenWare = neededKitchenWare;
        this.instructions = instructions;
    }

    @PrePersist
    @PreUpdate
    private void serializeInstructions() {
        if (instructions != null && !instructions.isEmpty()) {
            this.instructionsString = instructions.entrySet().stream()
                    .map(entry -> entry.getKey() + " - " + entry.getValue())
                    .collect(Collectors.joining("\n"));
        } else {
            this.instructionsString = null;
        }
    }

    @PostLoad
    private void deserializeInstructions() {
        if (instructionsString != null && !instructionsString.isEmpty()) {
            this.instructions = new HashMap<>();
            for (String entry : instructionsString.split("\n")) {
                String[] parts = entry.split(" - ", 2);
                if (parts.length == 2) {
                    Long key = Long.parseLong(parts[0].trim());
                    String value = parts[1].trim();
                    this.instructions.put(key, value);
                }
            }
        }
    }

}

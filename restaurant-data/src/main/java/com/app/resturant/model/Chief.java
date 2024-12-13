package com.app.resturant.model;


import com.app.resturant.model.constants.CHIEF_LEVEL;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "Chiefs")
@Entity
@NoArgsConstructor
public class Chief extends NamedBaseEntity{
    @Column(name = "chief_level")
    private CHIEF_LEVEL chiefLevel;


    @Column(name = "knownRecipes")
    @ManyToMany
    @JoinTable(
            name = "known_recipes_chief",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "chief_id")
    )
    private final List<Recipe> knownRecipes = new ArrayList<>();

    @Builder
    public Chief(String name, CHIEF_LEVEL chiefLevel, List<Recipe> knownRecipes){
        super(name);
        this.chiefLevel = chiefLevel;
        this.knownRecipes.clear();
        this.knownRecipes.addAll(knownRecipes);
    }

}

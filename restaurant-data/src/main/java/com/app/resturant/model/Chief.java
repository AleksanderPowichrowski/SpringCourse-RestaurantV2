package com.app.resturant.model;


import com.app.resturant.model.constants.CHIEF_LEVEL;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Chiefs")
@ToString
@Getter
@Setter
public class Chief extends BaseEntity{
    private String name;
    private CHIEF_LEVEL chiefLevel;
    private final List<Recipe> knownRecipes = new ArrayList<>();

    @Builder
    public Chief(String name, CHIEF_LEVEL chiefLevel, List<Recipe> knownRecipes){
        this.name = name;
        this.chiefLevel = chiefLevel;
        this.knownRecipes.clear();
        this.knownRecipes.addAll(knownRecipes);
    }

}

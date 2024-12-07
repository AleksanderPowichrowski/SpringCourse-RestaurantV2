package com.app.resturant.service.map;

import com.app.resturant.model.Chief;

import java.util.Set;

public class ChiefMapService extends AbstractMapService<Chief,Long>{

    @Override
    public Set<Chief> findAll() {
        return super.findAll();
    }

    @Override
    public Chief findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Chief save(Chief object) {
        return super.save(object);
    }

    @Override
    public void delete(Chief object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    public Chief findByName(String name){
        Chief chief = null;
        for(var entry : map.entrySet()){
            String entryName = entry.getValue().getName();
            if(entryName.equalsIgnoreCase(name))
               return entry.getValue();
        }
        throw new RuntimeException("There is no such chief with name: " + name);
    }

    public boolean checkIfChiefCanMakeRecipe(String name, String  recipeName){
        Chief chief = findByName(name);
        return chief.getKnownRecipes().stream().anyMatch(knownRecipe -> knownRecipe.getName().equalsIgnoreCase(recipeName));
    }

    public boolean checkIfChiefCanMakeRecipe(String name, Long RecipeID){
        Chief chief = findByName(name);
        return chief.getKnownRecipes().stream().anyMatch(knownRecipe -> knownRecipe.getId() == RecipeID);
    }
    public boolean checkIfChiefCanMakeRecipe(Long chiefID, Long RecipeID){
        Chief chief = findById(chiefID);
        return chief.getKnownRecipes().stream().anyMatch(knownRecipe -> knownRecipe.getId() == RecipeID);
    }
    public boolean checkIfChiefCanMakeRecipe(Long chiefID, String  recipeName){
        Chief chief = findById(chiefID);
        return chief.getKnownRecipes().stream().anyMatch(knownRecipe -> knownRecipe.getName().equalsIgnoreCase(recipeName));
    }
}

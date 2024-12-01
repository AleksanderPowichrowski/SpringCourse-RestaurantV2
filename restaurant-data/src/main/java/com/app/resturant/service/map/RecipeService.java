package com.app.resturant.service.map;

import com.app.resturant.model.Recipe;

import java.util.Map;
import java.util.Set;

public class RecipeService extends AbstractMapService<Recipe,Long>{

    @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }

    @Override
    public Recipe findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Recipe save(Recipe object) {
        return super.save(object);
    }

    @Override
    public void delete(Recipe object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    public Map<Long,String> addRecordToInstruction(Map<Long,String> instruction, String record){

        instruction.put(instruction.size()+ 1L,record);
        return instruction;
    }
}

package com.app.resturant.service.db;

import com.app.resturant.model.IngredientType;
import com.app.resturant.repositories.IngredientTypeDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
@Profile("db")
public class IngredientTypeDbService extends AbstractDbService<IngredientType,Long, IngredientTypeDbRepository> {

    public IngredientTypeDbService(IngredientTypeDbRepository repository) {
        super(repository);
    }

    public IngredientType getByName(String name){
       for(IngredientType ingredientType : repository.findAll()){
           if(ingredientType.getName().equalsIgnoreCase(name))
              return ingredientType;
       }

       return null;
   }

    @Override
    public IngredientType save(IngredientType object) {
        Iterator<IngredientType> repositoryIterator = repository.findAll().iterator();
        while(repositoryIterator.hasNext()){
            IngredientType ingredientType = repositoryIterator.next();
            if(ingredientType.getName().equalsIgnoreCase(object.getName()))
                throw new RuntimeException("Ingredient type '" + object.getName() + "' already exist.");
        }
        return super.save(object);
    }
}

package com.app.resturant.service.db;

import com.app.resturant.model.IngredientType;
import com.app.resturant.repositories.IngredientTypeDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

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

}

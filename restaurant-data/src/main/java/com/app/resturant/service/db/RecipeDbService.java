package com.app.resturant.service.db;

import com.app.resturant.model.Recipe;
import com.app.resturant.repositories.RecipeDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("db")
public class RecipeDbService extends AbstractDbService<Recipe,Long, RecipeDbRepository> {

    public RecipeDbService(RecipeDbRepository repository) {
        super(repository);
    }
}

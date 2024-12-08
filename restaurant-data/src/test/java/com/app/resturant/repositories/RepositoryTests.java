package com.app.resturant.repositories;



import com.app.resturant.model.IngredientType;
import com.app.resturant.repositories.IngredientTypeDbRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import com.app.restaurant.web.RestaurantWebApplication ;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestaurantWebApplication.class)
@Profile("db")
public class RepositoryTests {

    @Autowired
    private IngredientTypeDbRepository ingredientTypeDbRepository;

    @BeforeEach
    public void startup(){
    }

    @Test
    public void testIngredientTypeRepo(){
        Optional<IngredientType> ingredientTypes = ingredientTypeDbRepository.findByName("ONION");
        Assertions.assertTrue("ONION".equalsIgnoreCase(ingredientTypes.get().getName()));
    }

}

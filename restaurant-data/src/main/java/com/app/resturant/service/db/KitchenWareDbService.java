package com.app.resturant.service.db;


import com.app.resturant.model.KitchenWare;
import com.app.resturant.repositories.KitchenWareDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db")
public class KitchenWareDbService extends AbstractDbService<KitchenWare, Long, KitchenWareDbRepository> {

    public KitchenWareDbService(KitchenWareDbRepository repository) {
        super(repository);
    }

    public KitchenWare getByName(String name){
        for(KitchenWare ingredientType : repository.findAll()){
            if(ingredientType.getName().equalsIgnoreCase(name))
                 return ingredientType;
        }

        return null;
    }

}

package com.app.resturant.service.db;

import com.app.resturant.model.Chief;
import com.app.resturant.repositories.ChiefDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db")

public class ChiefDbService extends AbstractDbService<Chief,Long,ChiefDbRepository> {

    public ChiefDbService(ChiefDbRepository repository) {
        super(repository);
    }


    public Chief getByName(String name){

        for(Chief chief : repository.findAll()){
            if(chief.getName().equalsIgnoreCase(name))
                return chief;
        }
        return null;
    }
}

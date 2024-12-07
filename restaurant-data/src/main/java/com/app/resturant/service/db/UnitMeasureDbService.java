package com.app.resturant.service.db;

import com.app.resturant.model.UnitMeasure;
import com.app.resturant.repositories.UnitMeasureDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("db")
public class UnitMeasureDbService extends AbstractDbService<UnitMeasure,Long, UnitMeasureDbRepository> {

    public UnitMeasureDbService(UnitMeasureDbRepository repository) {
        super(repository);
    }
}

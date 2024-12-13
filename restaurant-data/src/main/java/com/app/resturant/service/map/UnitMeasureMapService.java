package com.app.resturant.service.map;

import com.app.resturant.model.UnitMeasure;
import org.springframework.context.annotation.Profile;

import java.util.Set;


@Profile("map")
public class UnitMeasureMapService extends AbstractMapService<UnitMeasure,Long> {

    @Override
    public Set<UnitMeasure> findAll() {
        return super.findAll();
    }

    @Override
    public UnitMeasure findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public UnitMeasure save(UnitMeasure object) {
        return super.save(object);
    }

    @Override
    public void delete(UnitMeasure object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}

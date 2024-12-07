package com.app.restaurant.web.mapper;

import java.util.Set;

public interface Mapper<T,R> {

    public R map(Set<T> object);
}

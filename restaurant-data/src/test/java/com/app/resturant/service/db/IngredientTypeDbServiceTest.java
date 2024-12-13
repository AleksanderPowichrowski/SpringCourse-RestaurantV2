package com.app.resturant.service.db;

import com.app.resturant.BasicRestaurantTest;
import com.app.resturant.model.IngredientType;
import com.app.resturant.repositories.IngredientTypeDbRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Profile;

import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Profile("db")
@ExtendWith(MockitoExtension.class)
class IngredientTypeDbServiceTest extends BasicRestaurantTest {

    @Mock
    IngredientTypeDbRepository repository;
    @InjectMocks
    IngredientTypeDbService service;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(Set.of(beef));

        Set<IngredientType> ingredientTypeSet = service.findAll();
        Assertions.assertEquals(1,ingredientTypeSet.size());
    }

    @Test
    void findById() {
        when(repository.findById(1l)).thenReturn(Optional.ofNullable(beef));
        Optional<IngredientType> ingredientType = Optional.ofNullable(service.findById(1l));
        Assertions.assertEquals(0,ingredientType.get().getId());
    }

    @Test
    void save() {
        when(repository.save(any())).thenReturn(beef);
        IngredientType savedIngredientType =  service.save(beef);
        verify(repository).save(any());
        Assertions.assertEquals(savedIngredientType,beef);
    }

    @Test
    void delete() {
        service.delete(beef);
        verify(repository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1l);
        verify(repository).deleteById(anyLong());
    }

    @Test
    void getByName() {
        when(repository.findAll()).thenReturn(Set.of(lamb));
        IngredientType ingredientType = service.getByName("LAMB");
        Assertions.assertEquals("LAMB",ingredientType.getName());
    }
}
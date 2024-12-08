package com.app.resturant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Table(name = "Units")
@Data

@AllArgsConstructor
@Entity
public class UnitMeasure extends NamedBaseEntity{
    @Builder
    public UnitMeasure(String name) {
        super(name);
    }


}

package com.app.resturant.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Table(name = "Units")
@Data
@Builder
@AllArgsConstructor
@Entity
public class UnitMeasure extends NamedBaseEntity{

    public UnitMeasure(String name) {
        super(name);
    }
}

package com.app.resturant.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@NoArgsConstructor
@Data
public class NamedBaseEntity extends BaseEntity{
    @Column(name = "name")
    private String name;

    public NamedBaseEntity(String name) {
        this.name=name;
    }
}

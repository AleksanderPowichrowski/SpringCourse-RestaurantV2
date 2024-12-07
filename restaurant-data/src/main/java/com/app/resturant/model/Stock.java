package com.app.resturant.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;


@EqualsAndHashCode(callSuper = true)
@Table(name = "stocks")
@Data
@Entity
@NoArgsConstructor
public class Stock extends BaseEntity{

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd:HH-mm")
    private LocalDateTime stockDate;

    @ElementCollection
    @CollectionTable(
            name = "stock_ingredients",
            joinColumns = @JoinColumn(name = "stock_id")
    )
    @MapKeyJoinColumns({
            @MapKeyJoinColumn(name = "type_id", referencedColumnName = "type_id"),
            @MapKeyJoinColumn(name = "unit_id", referencedColumnName = "unit_id")
    })
    @Column(name = "quantity")
    private Map<Ingredient, Long> ingredientStock;

    @Builder
    public Stock(Map<Ingredient, Long> ingredientStock, LocalDateTime stockDate ){
        this.ingredientStock = ingredientStock;
        this.stockDate = stockDate;
    }
}

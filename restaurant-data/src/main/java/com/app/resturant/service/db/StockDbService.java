package com.app.resturant.service.db;


import com.app.resturant.model.Stock;
import com.app.resturant.repositories.StockDbRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Profile("db")
public class StockDbService extends AbstractDbService<Stock, Long, StockDbRepository> {

    public StockDbService(StockDbRepository repository) {
        super(repository);
    }

    public Stock getByDate(Date date) {
        for (Stock stock : repository.findAll()) {
            if (stock.getStockDate().equals(date))
                return stock;
        }

        return null;
    }
}

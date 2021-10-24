package com.example.demo.services;

import com.example.demo.daos.PriceDao;
import com.example.demo.entities.PriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceService {

    private PriceDao priceDao;

    @Autowired
    public PriceService(PriceDao priceDao) {
        this.priceDao = priceDao;
    }

    public PriceEntity findByDateAndProductIdAndBrandId(LocalDateTime date, int productId, int brand) {
        return this.priceDao.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date, productId, brand)
                .stream()
                .findFirst()
                .orElseThrow();
    }
}

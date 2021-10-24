package com.example.demo.daos;

import com.example.demo.entities.BrandEntity;
import com.example.demo.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PriceDaoTest {

    @Autowired
    private PriceDao priceDao;

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
        List<PriceEntity> prices = this.priceDao.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(date, date,35455,1);
        assertEquals(1, prices.size());
        assertEquals(35.5, prices.get(0).getPrice());
    }
}

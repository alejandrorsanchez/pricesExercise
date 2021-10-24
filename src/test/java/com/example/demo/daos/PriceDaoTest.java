package com.example.demo.daos;

import com.example.demo.TestConfig;
import com.example.demo.entities.BrandEntity;
import com.example.demo.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class PriceDaoTest {

    @Autowired
    private PriceDao priceDao;

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        List<PriceEntity> prices = this.priceDao.findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(1, prices.size());
        assertEquals(35.5, prices.get(0).getPrice());
    }

    @Test
    void testVerification(){
        Optional<PriceEntity> priceEntity = this.priceDao.findById(0);
        assertEquals(35.5, priceEntity.orElseThrow().getPrice());
    }
}

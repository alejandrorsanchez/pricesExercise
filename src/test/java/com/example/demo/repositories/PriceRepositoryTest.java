package com.example.demo.repositories;

import com.example.demo.entities.BrandEntity;
import com.example.demo.entities.PriceEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(35.5, priceEntity.getPrice());
    }

    @Test
    void testVerification(){
        Optional<PriceEntity> priceEntity = this.priceRepository.findById(0);
        System.out.println(priceEntity);
        assertEquals(35.5, priceEntity.orElseThrow().getPrice());
    }
}

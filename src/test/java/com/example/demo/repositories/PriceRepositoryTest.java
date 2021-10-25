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
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class PriceRepositoryTest {

    @Autowired
    private PriceRepository priceRepository;

    @Test
    void testVerification(){
        Optional<PriceEntity> priceEntity = this.priceRepository.findById(0);
        System.out.println(priceEntity);
        assertEquals(35.5, priceEntity.orElseThrow().getPrice());
    }

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc1(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 10, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(35.50, priceEntity.getPrice());
    }

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc2(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 16, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(25.45, priceEntity.getPrice());
    }

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc3(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 14, 21, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(35.50, priceEntity.getPrice());
    }

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc4(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 15, 10, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(30.50, priceEntity.getPrice());
    }

    @Test
    void testFindByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc5(){
        LocalDateTime date = LocalDateTime.of(2020, Month.JUNE, 16, 21, 00, 00);
        BrandEntity brandEntity = new BrandEntity(1, "ZARA");
        PriceEntity priceEntity = this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(date, date,35455,brandEntity);
        assertEquals(38.95, priceEntity.getPrice());
    }
}

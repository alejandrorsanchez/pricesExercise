package com.example.demo.repositories;

import com.example.demo.entities.BrandEntity;
import com.example.demo.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Integer > {

    PriceEntity findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandOrderByPriorityDesc(LocalDateTime date, LocalDateTime date1, int productId, BrandEntity brandEntity);
}

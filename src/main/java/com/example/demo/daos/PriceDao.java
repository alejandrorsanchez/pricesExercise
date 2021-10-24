package com.example.demo.daos;

import com.example.demo.entities.BrandEntity;
import com.example.demo.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceDao extends JpaRepository<PriceEntity, Integer > {

    List<PriceEntity> findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime date, LocalDateTime date1, int productId, BrandEntity brandId);
}

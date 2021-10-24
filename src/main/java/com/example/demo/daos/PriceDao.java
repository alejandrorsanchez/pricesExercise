package com.example.demo.daos;

import com.example.demo.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDao extends JpaRepository<PriceEntity, Integer > {

    List<PriceEntity> findByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(LocalDateTime date, LocalDateTime date1, int productId, int brandId);
}

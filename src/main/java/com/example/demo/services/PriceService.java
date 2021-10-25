package com.example.demo.services;

import com.example.demo.api.dtos.PriceDto;
import com.example.demo.repositories.PriceRepository;
import com.example.demo.entities.BrandEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PriceService {

    private PriceRepository priceRepository;
    private BrandService brandService;

    @Autowired
    public PriceService(PriceRepository priceRepository, BrandService brandService) {
        this.priceRepository = priceRepository;
        this.brandService = brandService;
    }

    public PriceDto findByDateAndProductIdAndBrandId(LocalDateTime date, int productId, int brandId) {
        BrandEntity brandEntity = this.brandService.findById(brandId);
        return this.priceRepository.findFirstByStartDateLessThanAndEndDateGreaterThanAndProductIdAndBrandIdOrderByPriorityDesc(date, date, productId, brandEntity)
                .toPriceDto();
    }
}

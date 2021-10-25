package com.example.demo.api.resources;

import com.example.demo.api.dtos.PriceDto;
import com.example.demo.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(PriceResource.PRICES)
public class PriceResource {

    public static final String PRICES = "/prices";
    public static final String SEARCH = "/search";

    private PriceService priceService;

    @Autowired
    public PriceResource(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping(SEARCH)
    public PriceDto findByDateAndProductIdAndBrandId(@RequestParam(required = true) LocalDateTime date,
                                                     @RequestParam(required = true) int productId,
                                                     @RequestParam(required = true) int brandId){
        return this.priceService.findByDateAndProductIdAndBrandId(date, productId, brandId);
    }
}

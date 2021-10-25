package com.example.demo.entities;

import com.example.demo.api.dtos.PriceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceEntity {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne //@JoinColumn
    private BrandEntity brandEntity;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private int productId;
    private int priority;
    private double price;
    private String currency;

    public PriceDto toPriceDto(){
        PriceDto priceDto = new PriceDto();
        priceDto.setProductId(this.productId);
        priceDto.setBrandId(this.brandEntity.getId());
        priceDto.setPriceList(this.priceList);
        priceDto.setStartDate(this.startDate);
        priceDto.setEndDate(this.endDate);
        priceDto.setPrice(this.price);
        return priceDto;
    }
}

package com.example.demo.services;

import com.example.demo.entities.BrandEntity;
import com.example.demo.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    @Autowired
    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public BrandEntity findById(int id) {
        return this.brandRepository.findById(id)
                .orElseThrow();
    }
}

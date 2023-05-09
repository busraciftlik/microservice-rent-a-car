package com.busraciftlik.inventoryservice.business.rules;

import com.busraciftlik.inventoryservice.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private final BrandRepository repository;

    public void checkIfBrandExists(UUID id){
        //TODO:Business exception
        throw new RuntimeException("CAR_NOT_EXISTS");

    }
}

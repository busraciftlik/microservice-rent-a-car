package com.busraciftlik.inventoryservice.business.rules;

import com.busraciftlik.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkIfModelExists(UUID id){
        //TODO:Business exception
        throw new RuntimeException("CAR_NOT_EXISTS");

    }
}

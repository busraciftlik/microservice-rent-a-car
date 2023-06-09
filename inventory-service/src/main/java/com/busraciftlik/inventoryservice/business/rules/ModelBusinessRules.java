package com.busraciftlik.inventoryservice.business.rules;

import com.busraciftlik.common.util.exceptions.BusinessException;
import com.busraciftlik.inventoryservice.repository.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ModelBusinessRules {
    private final ModelRepository repository;

    public void checkIfModelExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MODEL_NOT_EXISTS");
        }
    }
}

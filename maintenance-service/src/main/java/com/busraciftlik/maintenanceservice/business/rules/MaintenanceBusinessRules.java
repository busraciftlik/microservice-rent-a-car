package com.busraciftlik.maintenanceservice.business.rules;

import com.busraciftlik.common.util.exceptions.BusinessException;
import com.busraciftlik.maintenanceservice.api.clients.CarClient;
import com.busraciftlik.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MaintenanceBusinessRules {
    private final MaintenanceRepository repository;
    private final CarClient carClient;

    public void checkIfMaintenanceExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("MAINTENANCE_NOT_EXISTS");
        }
    }

    public void checkIfMaintenanceCompleted(UUID id) {
        if (repository.findById(id).orElseThrow().isCompleted()) {
            throw new BusinessException("MAINTENANCE_ENDED_ALREADY");
        }
    }

    public void ensureCarIsAvailable(UUID carId) {
        var response = carClient.checkIfCarAvailable(carId);
        if (!response.isSuccess()) {
            throw new BusinessException(response.getMessage());
        }
    }
}

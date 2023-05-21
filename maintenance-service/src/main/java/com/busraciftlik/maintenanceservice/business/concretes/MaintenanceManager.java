package com.busraciftlik.maintenanceservice.business.concretes;

import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.maintenanceservice.business.abstracts.MaintenanceService;
import com.busraciftlik.maintenanceservice.business.dto.requests.create.CreateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.requests.update.UpdateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.responses.create.CreateMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetAllMaintenancesResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.update.UpdateMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.rules.MaintenanceBusinessRules;
import com.busraciftlik.maintenanceservice.repository.MaintenanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MaintenanceManager implements MaintenanceService {
    private final MaintenanceRepository repository;
    private final ModelMapperService mapper;
    private final MaintenanceBusinessRules rules;

    @Override
    public List<GetAllMaintenancesResponse> getAll() {
        return null;
    }

    @Override
    public GetMaintenanceResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreateMaintenanceResponse add(CreateMaintenanceRequest request) {
        return null;
    }

    @Override
    public UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

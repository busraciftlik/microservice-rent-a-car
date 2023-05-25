package com.busraciftlik.maintenanceservice.business.abstracts;

import com.busraciftlik.maintenanceservice.business.dto.requests.create.CreateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.requests.update.UpdateMaintenanceRequest;
import com.busraciftlik.maintenanceservice.business.dto.responses.create.CreateMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetAllMaintenancesResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.get.GetMaintenanceResponse;
import com.busraciftlik.maintenanceservice.business.dto.responses.update.UpdateMaintenanceResponse;

import java.util.List;
import java.util.UUID;

public interface MaintenanceService {

    List<GetAllMaintenancesResponse> getAll();

    GetMaintenanceResponse getById(UUID id);

    CreateMaintenanceResponse add(CreateMaintenanceRequest request);

    UpdateMaintenanceResponse update(UUID id, UpdateMaintenanceRequest request);
    void delete(UUID id);
    UpdateMaintenanceResponse complete(UUID id);

}

package com.busraciftlik.inventoryservice.business.abstracts;

import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateCarRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateCarResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetCarResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateCarResponse;

import java.util.List;
import java.util.UUID;

public interface CarService {
    List<GetAllCarsResponse> getAll();
    GetCarResponse getByI(UUID id);
    CreateCarResponse add(CreateCarRequest request);
    UpdateCarResponse update(UUID id, UpdateCarRequest request);
    void delete(UUID id);
}

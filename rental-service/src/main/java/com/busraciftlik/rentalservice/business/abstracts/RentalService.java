package com.busraciftlik.rentalservice.business.abstracts;

import com.busraciftlik.rentalservice.business.dto.requests.CreateRentalRequest;
import com.busraciftlik.rentalservice.business.dto.requests.UpdateRentalRequest;
import com.busraciftlik.rentalservice.business.dto.responses.CreateRentalResponse;
import com.busraciftlik.rentalservice.business.dto.responses.GetAllRentalsResponse;
import com.busraciftlik.rentalservice.business.dto.responses.GetRentalResponse;
import com.busraciftlik.rentalservice.business.dto.responses.UpdateRentalResponse;

import java.util.List;
import java.util.UUID;

public interface RentalService {
    List<GetAllRentalsResponse> getAll();
    GetRentalResponse getById(UUID id);
    CreateRentalResponse add(CreateRentalRequest request);
    UpdateRentalResponse update(UUID id, UpdateRentalRequest request);
    void delete(UUID id);
}

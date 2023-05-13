package com.busraciftlik.rentalservice.api.controllers;

import com.busraciftlik.rentalservice.business.abstracts.RentalService;
import com.busraciftlik.rentalservice.business.dto.requests.CreateRentalRequest;
import com.busraciftlik.rentalservice.business.dto.requests.UpdateRentalRequest;
import com.busraciftlik.rentalservice.business.dto.responses.CreateRentalResponse;
import com.busraciftlik.rentalservice.business.dto.responses.GetAllRentalsResponse;
import com.busraciftlik.rentalservice.business.dto.responses.GetRentalResponse;
import com.busraciftlik.rentalservice.business.dto.responses.UpdateRentalResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@AllArgsConstructor
@RequestMapping("/api/rentals")
public class RentalController {
    private final RentalService service;

    @GetMapping
    public List<GetAllRentalsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetRentalResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateRentalResponse add(@Valid @RequestBody CreateRentalRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateRentalResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateRentalRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
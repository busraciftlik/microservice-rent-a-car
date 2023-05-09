package com.busraciftlik.inventoryservice.api.controller;

import com.busraciftlik.inventoryservice.business.abstracts.CarService;
import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateCarRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateCarRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateCarResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllCarsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetCarResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cars")
public class CarsController {
    private final CarService service;

    @GetMapping()
    List<GetAllCarsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetCarResponse getById(@PathVariable UUID id) {
        return service.getByI(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateCarResponse add(@RequestBody CreateCarRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateCarResponse update(@PathVariable UUID id, @RequestBody UpdateCarRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

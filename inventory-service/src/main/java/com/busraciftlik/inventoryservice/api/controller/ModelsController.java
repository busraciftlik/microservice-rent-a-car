package com.busraciftlik.inventoryservice.api.controller;

import com.busraciftlik.inventoryservice.business.abstracts.ModelService;
import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateModelRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateModelRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateModelResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllModelsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetModelResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {
    private final ModelService service;
    @GetMapping()
    List<GetAllModelsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetModelResponse getById(@PathVariable UUID id) {
        return service.getByI(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateModelResponse add(@RequestBody CreateModelRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateModelResponse update(@PathVariable UUID id, @RequestBody UpdateModelRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }

}

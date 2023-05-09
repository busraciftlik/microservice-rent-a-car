package com.busraciftlik.inventoryservice.api.controller;

import com.busraciftlik.inventoryservice.business.abstracts.BrandService;
import com.busraciftlik.inventoryservice.business.dto.requests.create.CreateBrandRequest;
import com.busraciftlik.inventoryservice.business.dto.requests.update.UpdateBrandRequest;
import com.busraciftlik.inventoryservice.business.dto.responses.create.CreateBrandResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetAllBrandsResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.get.GetBrandResponse;
import com.busraciftlik.inventoryservice.business.dto.responses.update.UpdateBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {
    private final BrandService service;

    @GetMapping()
    List<GetAllBrandsResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    GetBrandResponse getById(@PathVariable UUID id) {
        return service.getByI(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateBrandResponse add(@RequestBody CreateBrandRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    UpdateBrandResponse update(@PathVariable UUID id, @RequestBody UpdateBrandRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}

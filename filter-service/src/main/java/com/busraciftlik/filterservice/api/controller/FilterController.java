package com.busraciftlik.filterservice.api.controller;

import com.busraciftlik.filterservice.business.abstracts.FilterService;
import com.busraciftlik.filterservice.business.dto.GetAllFiltersResponse;
import com.busraciftlik.filterservice.business.dto.GetFilterResponse;
import com.busraciftlik.filterservice.entities.Filter;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/filters")
public class FilterController {
    private final FilterService service;

    @PostConstruct
    public void createDb()
    { service.add(new Filter()); }

    @GetMapping
    public List<GetAllFiltersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

}



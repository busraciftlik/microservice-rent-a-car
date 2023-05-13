package com.busraciftlik.filterservice.api.controller;

import com.busraciftlik.filterservice.business.abstracts.FilterService;
import com.busraciftlik.filterservice.business.dto.GetAllFiltersResponse;
import com.busraciftlik.filterservice.business.dto.GetFilterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/filters")
public class FilterController {
    private final FilterService service;

    @GetMapping
    public List<GetAllFiltersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable String id) {
        return service.getById(id);
    }
}



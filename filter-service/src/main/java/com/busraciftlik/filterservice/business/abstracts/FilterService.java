package com.busraciftlik.filterservice.business.abstracts;

import com.busraciftlik.filterservice.business.dto.GetAllFiltersResponse;
import com.busraciftlik.filterservice.business.dto.GetFilterResponse;
import com.busraciftlik.filterservice.entities.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<GetAllFiltersResponse> getAll();
    GetFilterResponse getById(String id);
    void add(Filter filter);
    void delete(String id);
    void deleteByCarId(UUID carId);
    void deleteAllByBrandId(UUID brandId);
    void deleteAllByModelId(UUID modelId);
    Filter getByCarId(UUID carId);
}


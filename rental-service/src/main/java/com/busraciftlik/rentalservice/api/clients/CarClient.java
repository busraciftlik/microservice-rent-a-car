package com.busraciftlik.rentalservice.api.clients;


import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.GetCarResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import io.github.resilience4j.retry.annotation.Retry;

import java.util.UUID;
@FeignClient(name = "inventory-service", fallback = CarClientFallback.class)
public interface CarClient {
    @Retry(name = "retry-rental")
    @GetMapping(value = "/api/cars/check-car-available/{carId}")
    ClientResponse checkIfCarAvailable(@PathVariable UUID carId);

    @GetMapping(value = "/api/cars/{carId}")
    GetCarResponse getById(@PathVariable UUID carId);
}

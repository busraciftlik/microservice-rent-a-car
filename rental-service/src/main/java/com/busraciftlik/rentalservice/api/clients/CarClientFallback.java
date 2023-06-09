package com.busraciftlik.rentalservice.api.clients;

import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.GetCarResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class CarClientFallback implements CarClient {

    @Override
    public ClientResponse checkIfCarAvailable(UUID carId) {
        log.info("INVENTORY SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY-SERVICE NOT AVAILABLE RIGHT NOW! -- car client" );
    }

    @Override
    public GetCarResponse getById(UUID carId) {
        log.info("INVENTORY SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY-SERVICE NOT AVAILABLE RIGHT NOW!--get by id");
    }
}

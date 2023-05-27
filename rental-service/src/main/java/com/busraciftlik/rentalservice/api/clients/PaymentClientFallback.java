package com.busraciftlik.rentalservice.api.clients;

import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.CreateRentalPaymentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentClientFallback implements PaymentClient {

    @Override
    public ClientResponse checkIfPaymentAvailable(CreateRentalPaymentRequest request) {
        log.info("SERVICE IS DOWN!");
        throw new RuntimeException("INVENTORY-SERVICE NOT AVAILABLE RIGHT NOW!--Payment");
    }
}
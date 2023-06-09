package com.busraciftlik.rentalservice.api.clients;

import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.CreateRentalPaymentRequest;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "payment-service", fallback = PaymentClientFallback.class)
public interface PaymentClient {
    @PostMapping(value = "/api/payments/check-payment-process")
    @Retry(name = "retry-payment")
    ClientResponse checkIfPaymentAvailable(@RequestBody CreateRentalPaymentRequest request);
}

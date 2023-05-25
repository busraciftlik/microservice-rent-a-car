package com.busraciftlik.paymentservice.business.abstracts;

import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.CreateRentalPaymentRequest;
import com.busraciftlik.paymentservice.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.update.UpdatePaymentResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {
    List<GetAllPaymentsResponse> getAll();

    GetPaymentResponse getById(UUID id);

    CreatePaymentResponse add(CreatePaymentRequest request);

    UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request);

    void delete(UUID id);

    ClientResponse processRentalPayment(CreateRentalPaymentRequest request);
}


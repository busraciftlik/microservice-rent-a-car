package com.busraciftlik.paymentservice.business.concretes;

import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.paymentservice.business.abstracts.PaymentService;
import com.busraciftlik.paymentservice.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.update.UpdatePaymentResponse;
import com.busraciftlik.paymentservice.business.rules.PaymentBusinessRules;
import com.busraciftlik.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final PaymentRepository repository;
    private final ModelMapperService mapper;
    private final PaymentBusinessRules rules;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        return null;
    }

    @Override
    public GetPaymentResponse getById(UUID id) {
        return null;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        return null;
    }

    @Override
    public UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}

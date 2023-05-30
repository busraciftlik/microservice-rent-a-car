package com.busraciftlik.paymentservice.business.concretes;

import com.busraciftlik.common.util.dto.ClientResponse;
import com.busraciftlik.common.util.dto.CreateRentalPaymentRequest;
import com.busraciftlik.common.util.exceptions.BusinessException;
import com.busraciftlik.common.util.mapper.ModelMapperService;
import com.busraciftlik.paymentservice.business.abstracts.PaymentService;
import com.busraciftlik.paymentservice.business.abstracts.PosService;
import com.busraciftlik.paymentservice.business.dto.requests.create.CreatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.requests.update.UpdatePaymentRequest;
import com.busraciftlik.paymentservice.business.dto.responses.create.CreatePaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetAllPaymentsResponse;
import com.busraciftlik.paymentservice.business.dto.responses.get.GetPaymentResponse;
import com.busraciftlik.paymentservice.business.dto.responses.update.UpdatePaymentResponse;
import com.busraciftlik.paymentservice.business.rules.PaymentBusinessRules;
import com.busraciftlik.paymentservice.entities.Payment;
import com.busraciftlik.paymentservice.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentManager implements PaymentService {
    private final ModelMapperService mapper;
    private final PaymentRepository repository;
    private final PaymentBusinessRules rules;
    private final PosService posService;

    @Override
    public List<GetAllPaymentsResponse> getAll() {
        var brands = repository.findAll();
        var response = brands
                .stream()
                .map(brand -> mapper.forResponse().map(brand, GetAllPaymentsResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetPaymentResponse getById(UUID id) {
        rules.checkIfPaymentExists(id);
        var brand = repository.findById(id).orElseThrow();
        var response = mapper.forResponse().map(brand, GetPaymentResponse.class);

        return response;
    }

    @Override
    public CreatePaymentResponse add(CreatePaymentRequest request) {
        rules.checkIfCardNumberExists(request.getCardNumber());
        var brand = mapper.forRequest().map(request, Payment.class);
        var createdPayment = repository.save(brand);
        var response = mapper.forResponse().map(createdPayment, CreatePaymentResponse.class);

        return response;
    }

    @Override
    public UpdatePaymentResponse update(UUID id, UpdatePaymentRequest request) {
        rules.checkIfPaymentExists(id);
        var brand = mapper.forRequest().map(request, Payment.class);
        brand.setId(id);
        repository.save(brand);
        var response = mapper.forResponse().map(brand, UpdatePaymentResponse.class);

        return response;
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfPaymentExists(id);
        repository.deleteById(id);
    }

    @Override
    public ClientResponse processPayment(CreateRentalPaymentRequest request) {
        var response = new ClientResponse();
        processPaymentTransaction(request, response);

        return response;
    }

    private void processPaymentTransaction(CreateRentalPaymentRequest request, ClientResponse response) {
        try {
            rules.checkIfPaymentValid(request);
            var payment = repository.findByCardNumber(request.getCardNumber());
            double balance = payment.getBalance();
            rules.checkIfBalanceIsEnough(balance, request.getPrice());
            posService.pay();
            payment.setBalance(balance - request.getPrice());
            repository.save(payment);
            response.setSuccess(true);
        } catch (BusinessException exception) {
            response.setSuccess(false);
            response.setMessage(exception.getMessage());
        }
    }
}
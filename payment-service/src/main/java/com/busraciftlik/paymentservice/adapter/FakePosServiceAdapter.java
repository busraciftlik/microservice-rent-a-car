package com.busraciftlik.paymentservice.adapter;

import com.busraciftlik.common.util.exceptions.BusinessException;
import com.busraciftlik.paymentservice.business.abstracts.PosService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FakePosServiceAdapter implements PosService {
    @Override
    public void pay() {
        boolean isPaymentSucessful = new Random().nextBoolean();
        if (isPaymentSucessful) {
            throw new BusinessException("PAYMENT_FAILED");
        }
    }
}

package com.busraciftlik.common.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRentalPaymentRequest extends PaymentRequest {
    private double price;
}

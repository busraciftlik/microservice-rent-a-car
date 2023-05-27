package com.busraciftlik.common.util.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetCarResponse {
    private UUID id;
    private UUID modelId;
    private int modelYear;
    private String modelName;
    private String brandName;
    private String plate;
    private String state;
    private double dailyPrice;
}

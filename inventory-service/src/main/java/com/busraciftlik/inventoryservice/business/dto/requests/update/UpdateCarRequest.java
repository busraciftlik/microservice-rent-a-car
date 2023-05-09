package com.busraciftlik.inventoryservice.business.dto.requests.update;

import com.busraciftlik.common.util.annotations.NotFutureYear;
import com.busraciftlik.common.util.constants.Regex;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCarRequest {
    @NotBlank
    @NotNull
    private UUID modelId;
    @Min(value = 200)
    @NotFutureYear
    private int modelYear;
    @NotNull
    @NotBlank
    @Pattern(regexp = Regex.PLATE)
    private String Plate;
    @Min(value = 1)
    private double dailyPrice;
}

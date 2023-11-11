package com.example.Immutly.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetNewProductRequest {

    @NotNull
    private String productName;
    @NotNull
    private String productDescription;
    @NotNull
    @Min(0)
    private double price;
    @NotNull
    private boolean availabilityStatus;
}

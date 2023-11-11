package com.example.Immutly.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateRequest {


    private String productName;
    private String productDescription;
    @Min(0)
    private Double price;
    private Boolean availabilityStatus;
}

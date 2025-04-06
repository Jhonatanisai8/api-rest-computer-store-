package com.isai.democomputerstore.app.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateProductRequest {

    @NotEmpty
    private String productName;

    @NotNull
    private BigDecimal productPrice;

    @NotNull
    private Integer idMaker;
}

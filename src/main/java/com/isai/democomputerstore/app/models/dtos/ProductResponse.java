package com.isai.democomputerstore.app.models.dtos;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.isai.democomputerstore.app.models.entitys.Maker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // para que los campos no sean nulos
public class ProductResponse {
    private Integer idProduct;
    private String productName;
    private BigDecimal productPrice;
    private Maker maker;

}

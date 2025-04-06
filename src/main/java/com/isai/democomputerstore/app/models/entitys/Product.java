package com.isai.democomputerstore.app.models.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String productName;

    @NotNull
    private BigDecimal productPrice;

    //Manufacturer Relationship
    @ManyToOne
    @JoinColumn(name = "id_maker")
    private Maker maker;
}

package com.isai.democomputerstore.app.models.entitys;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "makers")
public class Maker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaker;

    @NotEmpty
    @Size(min = 2, max = 50)
    private String nameMaker;
}

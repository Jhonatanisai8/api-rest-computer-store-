package com.isai.democomputerstore.app.models.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MakerResponse {
    private Integer idMaker;
    private String nameMaker;
}

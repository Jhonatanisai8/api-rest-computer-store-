package com.isai.democomputerstore.app.mappers;

import com.isai.democomputerstore.app.models.dtos.MakerResponse;
import com.isai.democomputerstore.app.models.entitys.Maker;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MakerMapper {
    MakerResponse toResponse(Maker maker);
}

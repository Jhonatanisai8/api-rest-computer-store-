package com.isai.democomputerstore.app.mappers;

import com.isai.democomputerstore.app.models.dtos.ProductResponse;
import com.isai.democomputerstore.app.models.entitys.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = MakerMapper.class)
public interface ProductMapper {

    ProductResponse toProductResponse(Product product);

}

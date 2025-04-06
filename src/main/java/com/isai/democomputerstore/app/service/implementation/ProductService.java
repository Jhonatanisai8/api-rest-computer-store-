package com.isai.democomputerstore.app.service.implementation;

import com.isai.democomputerstore.app.exceptions.ProductNotFoundException;
import com.isai.democomputerstore.app.mappers.ProductMapper;
import com.isai.democomputerstore.app.models.dtos.CreateProductRequest;
import com.isai.democomputerstore.app.models.dtos.MakerResponse;
import com.isai.democomputerstore.app.models.dtos.ProductResponse;
import com.isai.democomputerstore.app.models.entitys.Product;
import com.isai.democomputerstore.app.repository.MakerRepository;
import com.isai.democomputerstore.app.repository.ProductRepository;
import com.isai.democomputerstore.app.service.CrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService
        implements CrudService<ProductResponse, MakerResponse, CreateProductRequest> {

    private final ProductRepository productRepository;

    private final MakerRepository makerRepository;

    private final ProductMapper productMapper;


    @Override
    public ProductResponse findById(Integer idSearch) {
        return productRepository.findById(idSearch)
                .map(productMapper::toProductResponse)
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponse)
                .toList();
    }

    @Override
    public ProductResponse save(CreateProductRequest entityRequest) {
        return makerRepository.findById(entityRequest.getIdMaker())
                .map(maker -> {
                    Product product = Product.builder()
                            .productName(entityRequest.getProductName())
                            .productPrice(entityRequest.getProductPrice())
                            .maker(maker)
                            .build();
                    return productRepository.save(product);
                }).map(productMapper::toProductResponse).
                orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public ProductResponse update(Integer idSearch, CreateProductRequest entityRequest) {
        return null;
    }

    @Override
    public void delete(Integer idSearch) {

    }
}

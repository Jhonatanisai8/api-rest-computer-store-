package com.isai.democomputerstore.app.controllers;

import com.isai.democomputerstore.app.models.dtos.CreateProductRequest;
import com.isai.democomputerstore.app.models.dtos.ProductResponse;
import com.isai.democomputerstore.app.service.implementation.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@PreAuthorize("denyAll()")
public class ProductController {
    private final ProductService productService;

    @PreAuthorize("hasAnyAuthority('READ')")
    @RequestMapping(path = "/findAllProducts", method = RequestMethod.GET)
    public List<ProductResponse> findAllProducts() {
        return productService.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER','DEVELOPER')")
    @RequestMapping(path = "/findProductById/{idProduct}", method = RequestMethod.GET)
    public ProductResponse findProductById(@Valid @PathVariable Integer idProduct) {
        return productService.findById(idProduct);
    }


    @PreAuthorize("hasAnyAuthority('READ')")
    @RequestMapping(path = "/findAllProductsByMaker/{idMaker}", method = RequestMethod.GET)
    public List<ProductResponse> findAllProductsByMaker(@Validated @PathVariable Integer idMaker) {
        return productService.findAllByMaker(idMaker);
    }

    @PreAuthorize("hasAnyAuthority('CREATED')")
    @RequestMapping(path = "/saveProduct", method = RequestMethod.POST)
    public ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
        ProductResponse productResponse = productService.save(createProductRequest);
        return ResponseEntity.created(URI.create("/api/v1/products".concat(productResponse.getIdProduct() + "")))
                .body(productResponse);
    }


    @PreAuthorize("hasAnyAuthority('UPDATE')")
    @RequestMapping(path = "/updateProduct/{idProduct}", method = RequestMethod.PUT)
    public ProductResponse updateProduct(@PathVariable Integer idProduct, @Valid @RequestBody CreateProductRequest createProductRequest) {
        return productService.update(idProduct, createProductRequest);
    }


    @RequestMapping(path = "/deleteProduct/{idProduct}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable Integer idProduct) {
        productService.delete(idProduct);
    }
}

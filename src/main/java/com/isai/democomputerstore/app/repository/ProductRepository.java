package com.isai.democomputerstore.app.repository;

import com.isai.democomputerstore.app.models.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {
}

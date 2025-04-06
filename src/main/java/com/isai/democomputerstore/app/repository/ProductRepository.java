package com.isai.democomputerstore.app.repository;

import com.isai.democomputerstore.app.models.entitys.Maker;
import com.isai.democomputerstore.app.models.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    List<Product> findAllByMaker(Maker maker);
}

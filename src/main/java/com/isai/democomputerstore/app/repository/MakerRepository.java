package com.isai.democomputerstore.app.repository;

import com.isai.democomputerstore.app.models.entitys.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository
        extends JpaRepository<Maker, Long> {
}

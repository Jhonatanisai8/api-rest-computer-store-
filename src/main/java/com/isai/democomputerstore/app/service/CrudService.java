package com.isai.democomputerstore.app.service;

import java.util.List;

public interface CrudService<T, U> {
    T findById(Integer idSearch);

    List<T> findAll();

    T save(U entityRequest);

    T update(Integer idSearch, U entityRequest);

    void delete(Integer idSearch);
}

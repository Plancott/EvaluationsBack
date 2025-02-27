package com.evaluations.iriarte.app.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.evaluations.iriarte.app.domain.model.Products;

public interface ProductsPersistencePort {
    Optional<Products> findById(Long id);
    List<Products> findAll();
    Products save(Products products);
    void deleteById(Long id);
    List<Products> findByName(String name);
    List<Products> findByCategory(Long categoryId);
}

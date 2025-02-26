package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import com.evaluations.iriarte.app.application.ports.output.ProductsPersistencePort;
import com.evaluations.iriarte.app.domain.model.Products;

public class ProductsPersistenceAdapter implements ProductsPersistencePort {

    @Override
    public Optional<Products> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Products> findAll() {
        return null;
    }

    @Override
    public Products save(Products products) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        
    }
    

}

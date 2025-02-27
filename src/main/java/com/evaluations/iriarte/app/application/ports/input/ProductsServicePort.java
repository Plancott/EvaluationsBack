package com.evaluations.iriarte.app.application.ports.input;

import java.util.List;

import com.evaluations.iriarte.app.domain.model.Products;

public interface ProductsServicePort {
    Products findById(Long id);
    List<Products> findAll();
    Products save(Products products);
    Products update(Long id, Products products);
    void deleteById(Long id);
    List<Products> searchProductsByName(String name);
    List<Products> getProductsByCategory(Long categoryId);
}

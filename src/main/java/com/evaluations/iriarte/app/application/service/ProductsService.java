package com.evaluations.iriarte.app.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.evaluations.iriarte.app.application.ports.input.ProductsServicePort;
import com.evaluations.iriarte.app.application.ports.output.CategoryPersistencePort;
import com.evaluations.iriarte.app.application.ports.output.ProductsPersistencePort;
import com.evaluations.iriarte.app.domain.model.Category;
import com.evaluations.iriarte.app.domain.model.Products;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService implements ProductsServicePort {
    private final ProductsPersistencePort productsPersistencePort;
    private final CategoryPersistencePort categoryPersistencePort;


    @Override
    public Products findById(Long id) {
        return productsPersistencePort.findById(id).orElseThrow();
    }

    @Override
    public List<Products> findAll() {
        return productsPersistencePort.findAll();
    }

    @Override
    public Products save(Products products) {
        Category category = categoryPersistencePort.findById(products.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        products.setCategory(category);
        return productsPersistencePort.save(products);
    }

    @Override
    public Products update(Long id, Products products) {
        return productsPersistencePort.findById(id)
                .map(productsFound -> {
                    Category category = categoryPersistencePort.findById(products.getCategory().getId())
                            .orElseThrow(() -> new RuntimeException("Category not found"));
                    products.setId(productsFound.getId());
                    products.setCategory(category);
                    return productsPersistencePort.save(products);
                }).orElseThrow();
    }

    @Override
    public void deleteById(Long id) {
        if (productsPersistencePort.findById(id).isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        productsPersistencePort.deleteById(id);
    }
    
    @Override
    public List<Products> searchProductsByName(String name) {
        // Obtener todos los productos y filtrar por coincidencia en el nombre
        return productsPersistencePort.findAll()
                .stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Products> getProductsByCategory(Long categoryId) {
        // Obtener todos los productos y filtrar por categoría
        return productsPersistencePort.findByCategory(categoryId);
    }

}

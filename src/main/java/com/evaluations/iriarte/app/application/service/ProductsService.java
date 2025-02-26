package com.evaluations.iriarte.app.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evaluations.iriarte.app.application.ports.input.ProductsServicePort;
import com.evaluations.iriarte.app.application.ports.output.ProductsPersistencePort;
import com.evaluations.iriarte.app.domain.exception.ProductsNotFoundException;
import com.evaluations.iriarte.app.domain.model.Products;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService implements ProductsServicePort {
    private final ProductsPersistencePort productsPersistencePort;


    @Override
    public Products findById(Long id) {
        return productsPersistencePort.findById(id).orElseThrow(ProductsNotFoundException::new);
    }

    @Override
    public List<Products> findAll() {
        return productsPersistencePort.findAll();
    }

    @Override
    public Products save(Products products) {
        return productsPersistencePort.save(products);
    }

    @Override
    public Products update(Long id, Products products) {
        
        return productsPersistencePort.findById(id)
                .map(productsFound -> {
                    products.setId(productsFound.getId());
                    return productsPersistencePort.save(products);
                }).orElseThrow(ProductsNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (productsPersistencePort.findById(id).isEmpty()) {
            throw new ProductsNotFoundException();
        }productsPersistencePort.deleteById(id);
    }

}

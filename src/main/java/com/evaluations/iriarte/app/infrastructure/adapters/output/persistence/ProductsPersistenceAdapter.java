package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;

import com.evaluations.iriarte.app.application.ports.output.ProductsPersistencePort;
import com.evaluations.iriarte.app.domain.model.Products;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.mapper.ProductsPersistanceMapper;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ProductsPersistenceAdapter implements ProductsPersistencePort {

    private final ProductsRepository productsRepository;

    private final ProductsPersistanceMapper productsPersistanceMapper;

    @Override
    public Optional<Products> findById(Long id) {
        return productsRepository.findById(id).map(productsPersistanceMapper::toProducts);
    }

    @Override
    public List<Products> findAll() {
        return productsPersistanceMapper.toProductsList(productsRepository.findAll());
    }

    @Override
    public Products save(Products products) {
        return productsPersistanceMapper.toProducts(productsRepository.save(productsPersistanceMapper.toProductsEntity(products)));
    }

    @Override
    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }
    public List<Products> findByName(String name) {
        return productsPersistanceMapper.toProductsList(productsRepository.findByNameContainingIgnoreCase(name));
    }

    public List<Products> findByCategory(Long categoryId) {
        return productsPersistanceMapper.toProductsList(productsRepository.findByCategory_Id(categoryId));
    }

}

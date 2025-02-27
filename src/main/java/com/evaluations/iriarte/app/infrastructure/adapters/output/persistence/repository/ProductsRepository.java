package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.ProductsEntity;

public interface ProductsRepository  extends JpaRepository<ProductsEntity, Long> {
    
    List<ProductsEntity> findByNameContainingIgnoreCase(String name);

    List<ProductsEntity> findByCategory_Id(Long categoryId);
}

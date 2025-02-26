package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluations.iriarte.app.domain.model.Products;

public interface ProductsRepository  extends JpaRepository<Products, Long> {

}

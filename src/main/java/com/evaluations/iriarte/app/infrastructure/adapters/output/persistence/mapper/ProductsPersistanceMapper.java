package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.evaluations.iriarte.app.domain.model.Products;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.ProductsEntity;


@Mapper(componentModel = "spring")
public interface ProductsPersistanceMapper {
    ProductsEntity toProductsEntity(Products products);

    Products toProducts(ProductsEntity productsEntity);

    List<Products> toProductsList(List<ProductsEntity> productsEntityList);
}

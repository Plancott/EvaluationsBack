package com.evaluations.iriarte.app.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.evaluations.iriarte.app.domain.model.Products;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.ProductsCreateRequest;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.ProductsResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductsRestMapper {

    Products toProducts(ProductsCreateRequest productsRequest);

    ProductsResponse toProductsResponse(Products products);

    List<ProductsResponse> toProductsResponseList(List<Products> productsList);

    
}

package com.evaluations.iriarte.app.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.evaluations.iriarte.app.domain.model.Category;
import com.evaluations.iriarte.app.domain.model.Products;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.CategoryRequestId;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.ProductsCreateRequest;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.CategoryResponse;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.ProductsResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductsRestMapper {

    @Mapping(target = "category", expression = "java(mapCategory(productsRequest.getCategory()))")

    Products toProducts(ProductsCreateRequest productsRequest);

    ProductsResponse toProductsResponse(Products products);

    List<ProductsResponse> toProductsResponseList(List<Products> productsList);

    default Category mapCategory(CategoryRequestId categoryRequest) {
        if (categoryRequest == null) {
            return null;
        }
        return new Category(categoryRequest.getId(), null); // Solo asignamos el ID
    }

    default CategoryResponse mapCategory(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryResponse(category.getId(), category.getName());
    }

}

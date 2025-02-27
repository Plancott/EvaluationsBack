package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.evaluations.iriarte.app.domain.model.Category;
import com.evaluations.iriarte.app.domain.model.Products;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.CategoryEntity;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.ProductsEntity;


@Mapper(componentModel = "spring" )
public interface ProductsPersistanceMapper {

    @Mapping(target = "category", source = "category")
    ProductsEntity toProductsEntity(Products products);

    @Mapping(target = "category", source = "category")
    Products toProducts(ProductsEntity productsEntity);

    List<Products> toProductsList(List<ProductsEntity> productsEntityList);

    default CategoryEntity mapCategory(Category category) {
        if (category == null) {
            return null;
        }
        return new CategoryEntity(category.getId(), category.getName());
    }

    default Category mapCategoryEntity(CategoryEntity categoryEntity) {
        if (categoryEntity == null) {
            return null;
        }
        return new Category(categoryEntity.getId(), categoryEntity.getName());
    }
}

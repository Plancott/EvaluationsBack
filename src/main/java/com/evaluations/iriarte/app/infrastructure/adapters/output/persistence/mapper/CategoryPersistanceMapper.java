package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.mapper;

import com.evaluations.iriarte.app.domain.model.Category;

import java.util.List;

import org.mapstruct.Mapper;

import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.entity.CategoryEntity;

@Mapper(componentModel = "spring")
public interface CategoryPersistanceMapper {
    CategoryEntity toCategoryEntity(Category category);

    Category toCategory(CategoryEntity categoryEntity);

    List<Category> toCategoryList(List<CategoryEntity> categoryEntityList);

}

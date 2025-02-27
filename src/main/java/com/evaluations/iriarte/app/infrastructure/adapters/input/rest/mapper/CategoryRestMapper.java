package com.evaluations.iriarte.app.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.evaluations.iriarte.app.domain.model.Category;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.CategoryCreateRequest;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.CategoryResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryRestMapper {

    Category toCategory(CategoryCreateRequest categoryRequest);

    CategoryResponse toCategoryResponse(Category category);

    List<CategoryResponse> toCategoryResponseList(List<Category> categoryList);
}

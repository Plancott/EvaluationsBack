package com.evaluations.iriarte.app.infrastructure.adapters.input.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluations.iriarte.app.application.service.CategoryService;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.mapper.CategoryRestMapper;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.CategoryCreateRequest;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.CategoryResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryRestAdapter {
    private final CategoryService categoryServicePort;
    private final CategoryRestMapper categoryRestMapper;
    
    @GetMapping("/v1/api")
    public List<CategoryResponse> findAll() {
        return categoryRestMapper.toCategoryResponseList(categoryServicePort.findAll());
    }

    @GetMapping("/v1/api/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryRestMapper.toCategoryResponse(categoryServicePort.findById(id));
    }

    @PostMapping ("/v1/api")
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryCreateRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryRestMapper.toCategoryResponse(categoryServicePort
                    .save(categoryRestMapper.toCategory(categoryRequest))));
    }

    @PutMapping("/v1/api/{id}")
    public CategoryResponse update(@PathVariable Long id, @Valid @RequestBody CategoryCreateRequest categoryRequest) {
        return categoryRestMapper.toCategoryResponse(categoryServicePort
            .update(id, categoryRestMapper.toCategory(categoryRequest)));
    }

    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id) {
        categoryServicePort.deleteById(id);
    }   
    
}

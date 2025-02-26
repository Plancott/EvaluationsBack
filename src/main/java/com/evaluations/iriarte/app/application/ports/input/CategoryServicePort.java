package com.evaluations.iriarte.app.application.ports.input;

import java.util.List;

import com.evaluations.iriarte.app.domain.model.Category;

public interface CategoryServicePort {
    Category findById(Long id);
    List<Category> findAll();
    Category save(Category category);
    Category update(Long id, Category category);
    void deleteById(Long id);
}

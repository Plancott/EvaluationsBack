package com.evaluations.iriarte.app.application.ports.output;

import java.util.List;
import java.util.Optional;

import com.evaluations.iriarte.app.domain.model.Category;

public interface CategoryPersistencePort {
    Optional<Category> findById(Long id);
    List<Category> findAll();
    Category save(Category category);
    void deleteById(Long id);
}

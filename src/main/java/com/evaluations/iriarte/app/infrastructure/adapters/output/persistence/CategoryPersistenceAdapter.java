package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import com.evaluations.iriarte.app.application.ports.output.CategoryPersistencePort;
import com.evaluations.iriarte.app.domain.model.Category;

public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        
    }

}

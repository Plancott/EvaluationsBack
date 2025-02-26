package com.evaluations.iriarte.app.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evaluations.iriarte.app.application.ports.input.CategoryServicePort;
import com.evaluations.iriarte.app.application.ports.output.CategoryPersistencePort;
import com.evaluations.iriarte.app.domain.exception.CategoryNotFoundException;
import com.evaluations.iriarte.app.domain.model.Category;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService implements CategoryServicePort {
    private final CategoryPersistencePort categoryPersistencePort;

    @Override
    public Category findById(Long id) {
        return categoryPersistencePort.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    public List<Category> findAll() {
        return categoryPersistencePort.findAll();
    }

    public Category save(Category category) {
        return categoryPersistencePort.save(category);
    }

    public Category update(Long id, Category category) {
        return categoryPersistencePort.findById(id)
                .map(categoryFound -> {
                    category.setId(categoryFound.getId());
                    return categoryPersistencePort.save(category);
                }).orElseThrow(CategoryNotFoundException::new);
    }
    
    public void deleteById(Long id) {
        if (categoryPersistencePort.findById(id).isEmpty()) {
            throw new CategoryNotFoundException();
        }categoryPersistencePort.deleteById(id);
    }

}

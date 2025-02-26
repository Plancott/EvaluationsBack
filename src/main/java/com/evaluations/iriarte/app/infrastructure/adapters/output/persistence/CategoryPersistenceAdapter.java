package com.evaluations.iriarte.app.infrastructure.adapters.output.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.evaluations.iriarte.app.application.ports.output.CategoryPersistencePort;
import com.evaluations.iriarte.app.domain.model.Category;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.mapper.CategoryPersistanceMapper;
import com.evaluations.iriarte.app.infrastructure.adapters.output.persistence.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryRepository categoryRepository;
    private final CategoryPersistanceMapper categoryPersistanceMapper;

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id).map(categoryPersistanceMapper::toCategory);
    }

    @Override
    public List<Category> findAll() {
        return categoryPersistanceMapper.toCategoryList(categoryRepository.findAll());
    }

    @Override
    public Category save(Category category) {
        return categoryPersistanceMapper.toCategory(categoryRepository.save(categoryPersistanceMapper.toCategoryEntity(category))); 
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

}

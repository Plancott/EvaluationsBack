package com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestId {
    @NotNull(message = "Category ID is required")
    private Long id;
}

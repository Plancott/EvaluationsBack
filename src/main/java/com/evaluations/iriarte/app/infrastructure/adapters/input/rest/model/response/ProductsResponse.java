package com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponse {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private CategoryResponse category;
}

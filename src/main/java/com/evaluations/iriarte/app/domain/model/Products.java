package com.evaluations.iriarte.app.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private Long id;
    private String name;
    private Integer price;
    private Integer stock;
    private Long categoryId;
}

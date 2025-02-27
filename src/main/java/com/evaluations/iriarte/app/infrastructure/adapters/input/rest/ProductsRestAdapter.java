package com.evaluations.iriarte.app.infrastructure.adapters.input.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluations.iriarte.app.application.service.ProductsService;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.mapper.ProductsRestMapper;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.request.ProductsCreateRequest;
import com.evaluations.iriarte.app.infrastructure.adapters.input.rest.model.response.ProductsResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsRestAdapter {

        private final ProductsService productsServicePort;
        private final ProductsRestMapper productsRestMapper;

        @GetMapping("/v1/api")
        public List<ProductsResponse> findAll() {
            return productsRestMapper.toProductsResponseList(productsServicePort.findAll());
        }
        

        @GetMapping("/v1/api/{id}")
        public ProductsResponse findById(@PathVariable Long id) {
            return productsRestMapper.toProductsResponse(productsServicePort.findById(id));
        }


        @PostMapping("/v1/api")
        public ResponseEntity<ProductsResponse> save(@Valid @RequestBody ProductsCreateRequest productsRequest) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(productsRestMapper.toProductsResponse(productsServicePort
                        .save(productsRestMapper.toProducts(productsRequest))));
        }
        
        @PutMapping("/v1/api/{id}")
        public ProductsResponse update(@PathVariable Long id, @Valid @RequestBody ProductsCreateRequest productsRequest) {
            return productsRestMapper.toProductsResponse(productsServicePort
                .update(id, productsRestMapper.toProducts(productsRequest)));
        }

        @DeleteMapping("/v1/api/{id}")
        public void delete(@PathVariable Long id) {
            productsServicePort.deleteById(id);
        }
}

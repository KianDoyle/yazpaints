package com.kd.yazpaints.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kd.yazpaints.services.ProductService;

import jakarta.websocket.server.PathParam;

import com.kd.yazpaints.models.Product;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/filter/{type}")
    public ResponseEntity<List<Product>> getProductsByType(@PathParam(value = "type") String type) {
        return ResponseEntity.ok(productService.getProductsByType(type));
    }
}

package com.kd.yazpaints.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kd.yazpaints.services.ProductService;

import com.kd.yazpaints.entities.CompleteProduct;
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
    public ResponseEntity<List<CompleteProduct>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/filter/type/{type}")
    public ResponseEntity<List<Product>> getProductsByType(@PathVariable String type) {
        return ResponseEntity.ok(productService.getProductsByType(type));
    }

    @GetMapping("filter/tag/{tag}")
    public ResponseEntity<List<Product>> getProductsByTag(@PathVariable String tag) {
        return ResponseEntity.ok(productService.getProductsByTag(tag)); 
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CompleteProduct> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
}

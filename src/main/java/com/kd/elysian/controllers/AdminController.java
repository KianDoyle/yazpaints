package com.kd.elysian.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.elysian.entities.CompleteProduct;
import com.kd.elysian.models.File;
import com.kd.elysian.models.Product;
import com.kd.elysian.models.ProductType;
import com.kd.elysian.models.Tag;
import com.kd.elysian.services.ProductService;

@RestController
@RequestMapping("/admin")
public class AdminController {
    
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/get/all")
    public ResponseEntity<List<CompleteProduct>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    @GetMapping("/types/get/all")
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        return ResponseEntity.ok(productService.getAllProductTypes());
    }

    @PostMapping("/types/add")
    public ResponseEntity<ProductType> addProductType(@RequestBody ProductType productType) {
        return ResponseEntity.ok(productService.addProductType(productType)); 
    }

    @DeleteMapping("/types/delete/{id}")
    public ResponseEntity<ProductType> deleteProductType(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProductType(id));
    }

    // TODO: Implement Tag management functionality
    @GetMapping("/tags/get/all")
    public ResponseEntity<List<Tag>> getAllProductTags() {
        return null;
    }

    @PostMapping("/tags/add")
    public ResponseEntity<Tag> addProductTag(@RequestBody Tag tag) {
        return null;
    }

    @DeleteMapping("/tags/delete/{id}")
    public ResponseEntity<Tag> deleteProductTag(@PathVariable Integer id) {
        return null; 
    }

    // TODO: Implement File managemment functionality 
    @GetMapping("/files/get/all")
    public ResponseEntity<List<File>> getAllFiles() {
        return null;
    }
    
    @PostMapping("/files/add")
    public ResponseEntity<File> addFile(@RequestBody File file) {
        return null; 
    }

    @DeleteMapping("/files/delete/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable Integer id) {
        return null; 
    }
}

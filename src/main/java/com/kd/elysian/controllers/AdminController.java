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
import org.springframework.web.multipart.MultipartFile;

import com.kd.elysian.entities.CompleteProduct;
import com.kd.elysian.models.File;
import com.kd.elysian.models.Filter;
import com.kd.elysian.models.Product;
import com.kd.elysian.models.ProductType;
import com.kd.elysian.models.Tag;
import com.kd.elysian.services.FileService;
import com.kd.elysian.services.FilterService;
import com.kd.elysian.services.ProductService;
import com.kd.elysian.services.TagService;


@RestController
@RequestMapping("/admin")
public class AdminController {
    
    private final ProductService productService;
    private final TagService tagService;
    private final FileService fileService;
    private final FilterService filterService;

    public AdminController(ProductService productService, TagService tagService, FileService fileService, FilterService filterService) {
        this.productService = productService;
        this.tagService = tagService;
        this.fileService = fileService;
        this.filterService = filterService;
    }

    // Products
    @GetMapping("/products/get/all")
    public ResponseEntity<List<CompleteProduct>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/products/get/id/{id}")
    public ResponseEntity<CompleteProduct> getProductById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    
    @PostMapping("/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }
    
    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }

    // Product Types
    @GetMapping("/types/get/all")
    public ResponseEntity<List<ProductType>> getAllProductTypes() {
        return ResponseEntity.ok(productService.getAllProductTypes());
    }

    @GetMapping("/types/get/id/{id}")
    public ResponseEntity<ProductType> getProductTypeById(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.getProductTypeById(id));
    }

    @PostMapping("/types/add")
    public ResponseEntity<ProductType> addProductType(@RequestBody ProductType productType) {
        return ResponseEntity.ok(productService.addProductType(productType)); 
    }

    @DeleteMapping("/types/delete/{id}")
    public ResponseEntity<ProductType> deleteProductType(@PathVariable Integer id) {
        return ResponseEntity.ok(productService.deleteProductType(id));
    }

    // Tags
    @GetMapping("/tags/get/all")
    public ResponseEntity<List<Tag>> getAllProductTags() {
        return ResponseEntity.ok(tagService.getAllTags());
    }

    @PostMapping("/tags/add")
    public ResponseEntity<Tag> addProductTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.addTag(tag));
    }

    @DeleteMapping("/tags/delete/{id}")
    public ResponseEntity<Tag> deleteProductTag(@PathVariable Integer id) {
        return ResponseEntity.ok(tagService.deleteTag(id));
    }

    // Files
    @GetMapping("/files/get/all")
    public ResponseEntity<List<File>> getAllFiles() {
        return ResponseEntity.ok(fileService.getAllFiles());
    }

    @GetMapping("/files/get/{id}")
    public ResponseEntity<File> getFileById(@PathVariable Integer id) {
        return ResponseEntity.ok(fileService.getFileById(id));
    }

    @PostMapping("/files/add")
    public ResponseEntity<File> addFile(@RequestBody MultipartFile file) {
        return ResponseEntity.ok(fileService.saveFileToBucket(file));
    }

    @DeleteMapping("/files/delete/{id}")
    public ResponseEntity<File> deleteFile(@PathVariable Integer id) {
        return ResponseEntity.ok(fileService.deleteFile(id));
    }

    // Filters
    @GetMapping("/filters/get/all")
    public ResponseEntity<List<Filter>> getAllFilters() {
        return ResponseEntity.ok(filterService.getAllFilters());
    }

    @GetMapping("/filters/get/{id}")
    public ResponseEntity<Filter> getFilterById(@PathVariable Integer id) {
        return ResponseEntity.ok(filterService.getFilterById(id));
    }

    @PostMapping("/filters/add")
    public ResponseEntity<Filter> addFilter(@RequestBody Filter filter) {
        return ResponseEntity.ok(filterService.addFilter(filter));
    }

    @DeleteMapping("/filters/delete/{id}")
    public ResponseEntity<Filter> deleteFilter(@PathVariable Integer id) {
        return ResponseEntity.ok(filterService.deleteFilter(id));
    }
}

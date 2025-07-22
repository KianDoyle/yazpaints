package com.kd.yazpaints.services;

import org.springframework.stereotype.Service;
import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductType;
import com.kd.yazpaints.repositories.ProductRepository;
import com.kd.yazpaints.repositories.ProductTypeRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    
    public ProductService(ProductRepository productRepository, ProductTypeRepository productTypeRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public List<Product> getProductsByType(String type) {
        List<ProductType> validTypes = productTypeRepository.findAll();
        
        ProductType productType = validTypes.stream()
            .filter(pt -> pt.equals(type))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Product type not found: " + type));

        return productRepository.findAllByProductType(productType);
    } 

}

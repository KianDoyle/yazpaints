package com.kd.elysian.services;

import org.springframework.stereotype.Service;

import com.kd.elysian.entities.CompleteProduct;
import com.kd.elysian.models.File;
import com.kd.elysian.models.Product;
import com.kd.elysian.models.ProductImage;
import com.kd.elysian.models.ProductReview;
import com.kd.elysian.models.ProductTag;
import com.kd.elysian.models.ProductType;
import com.kd.elysian.models.Review;
import com.kd.elysian.models.Tag;
import com.kd.elysian.repositories.ProductImageRepository;
import com.kd.elysian.repositories.ProductRepository;
import com.kd.elysian.repositories.ProductReviewRepository;
import com.kd.elysian.repositories.ProductTagRepository;
import com.kd.elysian.repositories.ProductTypeRepository;
import com.kd.elysian.repositories.TagRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final TagRepository tagRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductReviewRepository productReviewRepository;
    private final ProductTagRepository productTagRepository;

    public ProductService(ProductRepository productRepository, 
                          ProductTypeRepository productTypeRepository,
                          TagRepository tagRepository,
                          ProductImageRepository productImageRepository,
                          ProductReviewRepository productReviewRepository,
                          ProductTagRepository productTagRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.tagRepository = tagRepository;
        this.productImageRepository = productImageRepository;
        this.productReviewRepository = productReviewRepository;
        this.productTagRepository = productTagRepository;
    }

    public List<CompleteProduct> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductImage> productImages = productImageRepository.findAll();
        List<ProductReview> productReviews = productReviewRepository.findAll();
        List<ProductTag> productTags = productTagRepository.findAll();

        ArrayList<CompleteProduct> completeProducts = new ArrayList<>();

        for (Product product : products) {
            List<File> files = productImages.stream().filter(pi -> pi.getProductId().equals(product)).map(pi -> pi.getFileId()).toList();
            List<Review> reviews = productReviews.stream().filter(pr -> pr.getProductId().equals(product)).map(pr -> pr.getReviewId()).toList();
            List<Tag> tags = productTags.stream().filter(pt -> pt.getProductId().equals(product)).map(pt -> pt.getTagId()).toList();
            
            completeProducts.add(new CompleteProduct(product, files, reviews, tags));
        };

        return completeProducts;
    }
    
    public List<Product> getProductsByType(String type) {
        Optional<ProductType> validType = productTypeRepository.findByName(type);
        
        if (validType.isEmpty()) {
            throw new IllegalArgumentException("Invalid product type: " + type);
        } 
        
        return productRepository.findAllByProductType(validType.get());
    }

    public List<Product> getProductsByTag(String tag) {
        Optional<Tag> validTag = tagRepository.findByName(tag);

        if (validTag.isEmpty()) {
            throw new IllegalArgumentException("Invalid tag: " + tag);
        }

        List<ProductTag> productTags = productTagRepository.findAllByTagId(validTag.get());

        return productTags.stream().map(pt -> pt.getProductId()).toList();
    }

    public CompleteProduct getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Could not find product with ID: " + id));

        List<ProductImage> productImages = productImageRepository.findAllByProductId(product);
        List<ProductReview> productReviews = productReviewRepository.findAllByProductId(product);
        List<ProductTag> productTags = productTagRepository.findAllByProductId(product);
        
        List<File> images = productImages.stream().map(pi -> pi.getFileId()).toList();
        List<Review> reviews = productReviews.stream().map(pr -> pr.getReviewId()).toList();
        List<Tag> tags = productTags.stream().map(pi -> pi.getTagId()).toList();

        return new CompleteProduct(product, images, reviews, tags);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    } 

    public Product deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " does not exist."));
        productRepository.delete(productRepository.findById(id).get());
        return product;
    }

    public List<ProductType> getAllProductTypes() {
        return productTypeRepository.findAll();
    }

    public ProductType addProductType(ProductType productType) {
        return productTypeRepository.save(productType);
    }

    public ProductType deleteProductType(Integer id) {
        ProductType productType = productTypeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product type with ID " + id + " does not exist."));
        productTypeRepository.delete(productType);
        return productType; 
    }

}

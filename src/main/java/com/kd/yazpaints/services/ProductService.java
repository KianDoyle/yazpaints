package com.kd.yazpaints.services;

import org.springframework.stereotype.Service;
import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductImage;
import com.kd.yazpaints.models.ProductReview;
import com.kd.yazpaints.models.ProductTag;
import com.kd.yazpaints.models.ProductType;
import com.kd.yazpaints.repositories.FileRepository;
import com.kd.yazpaints.repositories.ProductImageRepository;
import com.kd.yazpaints.repositories.ProductReviewRepository;
import com.kd.yazpaints.repositories.ProductTagRepository;
import com.kd.yazpaints.repositories.ProductRepository;
import com.kd.yazpaints.repositories.ProductTypeRepository;
import com.kd.yazpaints.repositories.ReviewRepository;
import com.kd.yazpaints.repositories.TagRepository;
import com.kd.yazpaints.entities.CompleteProduct;
import com.kd.yazpaints.models.File;
import com.kd.yazpaints.models.Review;
import com.kd.yazpaints.models.Tag;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    private final FileRepository fileRepository;
    private final ReviewRepository reviewRepository;
    private final TagRepository tagRepository;
    private final ProductImageRepository productImageRepository;
    private final ProductReviewRepository productReviewRepository;
    private final ProductTagRepository productTagRepository;

    public ProductService(ProductRepository productRepository, 
                          ProductTypeRepository productTypeRepository,
                          FileRepository fileRepository,
                          ReviewRepository reviewRepository,
                          TagRepository tagRepository,
                          ProductImageRepository productImageRepository,
                          ProductReviewRepository productReviewRepository,
                          ProductTagRepository productTagRepository) {
        this.productRepository = productRepository;
        this.productTypeRepository = productTypeRepository;
        this.fileRepository = fileRepository;
        this.reviewRepository = reviewRepository;
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
        List<ProductType> validTypes = productTypeRepository.findAll();
        
        ProductType productType = validTypes.stream()
            .filter(pt -> pt.equals(type))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("Product type not found: " + type));

        return productRepository.findAllByProductType(productType);
    } 

}

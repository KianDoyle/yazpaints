package com.kd.yazpaints.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductReview;
import com.kd.yazpaints.models.ProductReviewId;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, ProductReviewId> {
    public List<ProductReview> findAllByProductId(Product product);
}

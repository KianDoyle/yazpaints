package com.kd.yazpaints.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.yazpaints.models.ProductReview;
import com.kd.yazpaints.models.ProductReviewId;

@Repository
public interface ProductReviewRepository extends JpaRepository<ProductReview, ProductReviewId> {
    
}

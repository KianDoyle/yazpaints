package com.kd.yazpaints.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kd.yazpaints.models.ProductImage;
import com.kd.yazpaints.models.ProductImageId;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, ProductImageId> {
    
}

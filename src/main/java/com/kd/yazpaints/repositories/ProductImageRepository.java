package com.kd.yazpaints.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductImage;
import com.kd.yazpaints.models.ProductImageId;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, ProductImageId> {
    public List<ProductImage> findAllByProductId(Product product);
}

package com.kd.elysian.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.elysian.models.Product;
import com.kd.elysian.models.ProductImage;
import com.kd.elysian.models.ProductImageId;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, ProductImageId> {
    public List<ProductImage> findAllByProductId(Product product);
}

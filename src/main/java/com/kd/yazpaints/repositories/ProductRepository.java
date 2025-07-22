package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductType(ProductType productType);
}

package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.ProductType;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    Optional<ProductType> findByName(String type);

}

package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.ProductType;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {

    Optional<ProductType> findByName(String type);

}

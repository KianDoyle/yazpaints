package com.kd.yazpaints.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kd.yazpaints.models.ProductTag;
import com.kd.yazpaints.models.ProductTagId;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, ProductTagId> {
    
}

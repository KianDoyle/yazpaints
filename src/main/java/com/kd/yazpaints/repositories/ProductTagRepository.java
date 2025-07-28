package com.kd.yazpaints.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.yazpaints.models.Product;
import com.kd.yazpaints.models.ProductTag;
import com.kd.yazpaints.models.ProductTagId;
import com.kd.yazpaints.models.Tag;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, ProductTagId> {
    public List<ProductTag> findAllByProductId(Product product);
    public List<ProductTag> findAllByTagId(Tag tag);
}
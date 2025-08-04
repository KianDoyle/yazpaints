package com.kd.elysian.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.elysian.models.Product;
import com.kd.elysian.models.ProductTag;
import com.kd.elysian.models.ProductTagId;
import com.kd.elysian.models.Tag;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, ProductTagId> {
    public List<ProductTag> findAllByProductId(Product product);
    public List<ProductTag> findAllByTagId(Tag tag);
}
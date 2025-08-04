package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.Review;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

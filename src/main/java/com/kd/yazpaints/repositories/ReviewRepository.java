package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}

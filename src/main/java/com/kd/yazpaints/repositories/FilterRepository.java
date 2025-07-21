package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Filter;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

}

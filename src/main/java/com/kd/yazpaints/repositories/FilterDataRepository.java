package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.FilterData;

@Repository
public interface FilterDataRepository extends JpaRepository<FilterData, Integer> {

}

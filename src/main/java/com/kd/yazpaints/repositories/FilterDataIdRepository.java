package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.FilterDataId;

@Repository
public interface FilterDataIdRepository extends JpaRepository<FilterDataId, Integer> {

}

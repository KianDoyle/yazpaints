package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.FilterData;
import com.kd.elysian.models.FilterDataId;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FilterDataRepository extends JpaRepository<FilterData, FilterDataId> {

}

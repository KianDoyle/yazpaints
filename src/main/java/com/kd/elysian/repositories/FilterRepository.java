package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.Filter;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FilterRepository extends JpaRepository<Filter, Integer> {

}

package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.SiteData;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface SiteDataRepository extends JpaRepository<SiteData, Integer> {

}

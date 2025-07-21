package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.SiteData;

@Repository
public interface SiteDataRepository extends JpaRepository<SiteData, Integer> {

}

package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

}

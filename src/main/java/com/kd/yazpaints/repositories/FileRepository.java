package com.kd.yazpaints.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.kd.yazpaints.models.File;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}

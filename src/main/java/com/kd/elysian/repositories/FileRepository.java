package com.kd.elysian.repositories;

import org.springframework.stereotype.Repository;

import com.kd.elysian.models.File;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FileRepository extends JpaRepository<File, Integer> {

}

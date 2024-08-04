package com.webmvcHomework.__home_work.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webmvcHomework.__home_work.entity.departmentEntity;

/**
 * departmentRepo
 */
@Repository
public interface departmentRepo extends JpaRepository<departmentEntity , Long > {
// it will perform all crud operations
    
}
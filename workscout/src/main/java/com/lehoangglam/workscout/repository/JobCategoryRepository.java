package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Integer>, JpaSpecificationExecutor<JobCategory> {

}
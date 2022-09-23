package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobTypeRepository extends JpaRepository<JobType, Integer>, JpaSpecificationExecutor<JobType> {

}
package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.JobPostActivity;
import com.lehoangglam.workscout.entities.JobPostActivityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobPostActivityRepository extends JpaRepository<JobPostActivity, JobPostActivityPK>, JpaSpecificationExecutor<JobPostActivity> {

}
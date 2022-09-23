package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JobPostRepository extends JpaRepository<JobPost, Integer>, JpaSpecificationExecutor<JobPost> {

}
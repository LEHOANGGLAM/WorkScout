package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.JobPost;
import com.lehoangglam.workscout.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost, Integer>, JpaSpecificationExecutor<JobPost> {
    List<JobPost> findByCompanyId(final Optional<Company> id);
}
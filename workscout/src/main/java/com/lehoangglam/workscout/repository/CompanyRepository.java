package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompanyRepository extends JpaRepository<Company, Integer>, JpaSpecificationExecutor<Company> {

}
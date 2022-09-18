package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.BusinessType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BusinessTypeRepository extends JpaRepository<BusinessType, Integer>, JpaSpecificationExecutor<BusinessType> {

}
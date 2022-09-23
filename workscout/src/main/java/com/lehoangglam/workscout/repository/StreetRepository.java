package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StreetRepository extends JpaRepository<Street, Integer>, JpaSpecificationExecutor<Street> {

}
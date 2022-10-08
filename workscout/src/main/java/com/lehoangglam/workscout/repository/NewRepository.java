package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NewRepository extends JpaRepository<New, Integer>, JpaSpecificationExecutor<New> {

}
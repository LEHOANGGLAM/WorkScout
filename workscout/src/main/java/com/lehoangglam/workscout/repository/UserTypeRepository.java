package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserTypeRepository extends JpaRepository<UserType, Integer>, JpaSpecificationExecutor<UserType> {

}
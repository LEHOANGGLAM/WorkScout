package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.UserType;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface UserTypeRepository extends JpaRepository<UserType, Integer>, JpaSpecificationExecutor<UserType> {
    Optional<UserType> findByUserTypeName(String name);
}
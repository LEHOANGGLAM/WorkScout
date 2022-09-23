package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LocationRepository extends JpaRepository<Location, Integer>, JpaSpecificationExecutor<Location> {

}
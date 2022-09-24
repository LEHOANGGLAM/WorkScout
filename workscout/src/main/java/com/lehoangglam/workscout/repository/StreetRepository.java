package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.Company;
import com.lehoangglam.workscout.entities.Street;
import com.lehoangglam.workscout.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface StreetRepository extends JpaRepository<Street, Integer>, JpaSpecificationExecutor<Street> {
    Street findByUserId(final Optional<UserAccount> id);
    List<Street> findByCompanyId(final Optional<Company> id);
}
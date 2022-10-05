
package com.lehoangglam.workscout.repository;

import com.lehoangglam.workscout.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer>, JpaSpecificationExecutor<UserAccount> {
    UserAccount findByUsername(String username);
    UserAccount findById(int id);
}
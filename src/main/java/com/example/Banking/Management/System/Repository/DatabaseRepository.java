package com.example.Banking.Management.System.Repository;

import com.example.Banking.Management.System.Entity.AccountCreation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<AccountCreation, Long> {
}

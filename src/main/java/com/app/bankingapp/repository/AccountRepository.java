package com.app.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.bankingapp.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // Once AccountRepository interface extends JpaRepository then it will get the
    // CRUD methods to perform CRUD database operations on Account entity.
}

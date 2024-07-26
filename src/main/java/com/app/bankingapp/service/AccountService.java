package com.app.bankingapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.bankingapp.model.Account;
import com.app.bankingapp.repository.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    //add acc to database
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    //retrieve an acc's details by id
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    // deposits a specified amount into account-->update
    public Account deposit(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    //withdraw amount from an acc-->delete
    public Account withdraw(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }


}

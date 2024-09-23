package com.example.Banking.Management.System.Service;

import com.example.Banking.Management.System.Entity.AccountCreation;
import com.example.Banking.Management.System.Repository.DatabaseRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountServiceImpl implements AccountService{

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private DatabaseRepository databaseRepository;


    @Override
    public AccountCreation addAccount(AccountCreation accountCreation) {
        databaseRepository.save(accountCreation);
        log.info("Account added successfully");
        return accountCreation;
    }

    @Override
    public List<AccountCreation> getAllAccounts() {
        return databaseRepository.findAll();
    }

    @Override
    public String deleteAccount(long id) {
        databaseRepository.deleteById(id);
        return "Account deleted successfully";
    }

    @Override
    public AccountCreation updateAccount(long id) {
        return databaseRepository.findById(id).get();

    }
}

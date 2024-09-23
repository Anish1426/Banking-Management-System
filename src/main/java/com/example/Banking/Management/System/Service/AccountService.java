package com.example.Banking.Management.System.Service;


import com.example.Banking.Management.System.Entity.AccountCreation;

import java.util.List;


public interface AccountService {
    AccountCreation addAccount(AccountCreation accountCreation);
    List<AccountCreation> getAllAccounts();
    String deleteAccount(long id);
    AccountCreation updateAccount(long id);

}

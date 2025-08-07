package com.example.Blog.Service;

import com.example.Blog.Model.Account;
import com.example.Blog.Repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepo accountRepo;

    public void saveAccount(Account account){
        accountRepo.save(account);
    }
}

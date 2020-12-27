package com.iljaust.service;

import com.iljaust.model.Account;
import com.iljaust.respository.AccountRepository;
import com.iljaust.respository.hibernate.AccountRepositoryImpl;

import java.util.List;

public class AccountService {
    private AccountRepository accountRepository = new AccountRepositoryImpl();

    public List<Account> getAll(){

        return accountRepository.getAll();

    }

    public Account update(Account account) {

        return accountRepository.update(account);

    }

    public void deleteById(Long id) {

        accountRepository.deleteById(id);

    }

    public Account save(Account account) {

        accountRepository.save(account);
        return account;

    }

    public Account getById(Long id) {

        return accountRepository.getById(id);

    }
}

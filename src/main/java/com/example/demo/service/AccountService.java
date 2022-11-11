package com.example.demo.service;

import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    public List<Account> listAllAccount() {
        return accountRepository.findAll();
    }

    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    public Account getAccount(Integer id) {
        return accountRepository.findById(id).get();
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }
}

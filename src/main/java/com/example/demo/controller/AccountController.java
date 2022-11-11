package com.example.demo.controller;

import com.example.demo.model.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("")
    public List<Account> list() {
        return accountService.listAllAccount();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable Integer id) {
        try {
            Account account = accountService.getAccount(id);
            return new ResponseEntity<Account>(account, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/")
    public void add(@RequestBody Account account) {
        accountService.saveAccount(account);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Account account, @PathVariable Integer id) {
        try {
            Account existAccount = accountService.getAccount(id);
            account.setId(id);            
            accountService.saveAccount(account);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {

        accountService.deleteAccount(id);
    }
}
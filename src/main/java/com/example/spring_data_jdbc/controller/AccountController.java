package com.example.spring_data_jdbc.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_data_jdbc.model.Account;
import com.example.spring_data_jdbc.model.TransferRequest;
import com.example.spring_data_jdbc.repository.AccountRepository;
import com.example.spring_data_jdbc.service.TransferService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class AccountController {

  private final TransferService transferService;
  private final AccountRepository accountRepository;

  public AccountController(TransferService transferService, AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
    this.transferService = transferService;
  }

  @PostMapping("/transfer")
  public void transferMoney(@RequestBody TransferRequest request) {
    transferService.transferMoney(
      request.getSenderAccountId(), 
      request.getReceiverAccountId(), 
      request.getAmount()
    );
  }

  @GetMapping("/accounts")
  public Iterable<Account> getAccounts(@RequestParam(required = false) String name) {
    return (name == null) ? accountRepository.findAll() : accountRepository.findAccountsByName(name);
  }

}

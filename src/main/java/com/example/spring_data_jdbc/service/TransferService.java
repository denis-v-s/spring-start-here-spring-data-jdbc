package com.example.spring_data_jdbc.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_data_jdbc.exception.AccountNotFoundException;
import com.example.spring_data_jdbc.model.Account;
import com.example.spring_data_jdbc.repository.AccountRepository;


@Service
@Transactional
public class TransferService {

  private static final Logger logger = LoggerFactory.getLogger(TransferService.class.getName());
  private final AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public void transferMoney(long idSender, long idReceiver, BigDecimal amount) {
    Account sender = accountRepository.findById(idSender).orElseThrow(() -> new AccountNotFoundException());
    Account receiver = accountRepository.findById(idReceiver).orElseThrow(() -> new AccountNotFoundException());

    logger.info("Transferring {} from {} to {}", amount, sender.getName(), receiver.getName());

    BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
    BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

    accountRepository.changeAmount(idSender, senderNewAmount);
    accountRepository.changeAmount(idReceiver, receiverNewAmount);

    logger.info("Transfer complete. New balance for {}: {}, New balance for {}: {}", 
      sender.getName(), senderNewAmount, receiver.getName(), receiverNewAmount);
  }

}

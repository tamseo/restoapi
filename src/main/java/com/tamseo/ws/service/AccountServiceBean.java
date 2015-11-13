package com.tamseo.ws.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamseo.ws.model.Account;
import com.tamseo.ws.repository.AccountRepository;

/**
 * The AccountServiceBean encapsulates all business behaviors for operations on the Account entity
 * model and some related entities such as Role.
 * 
 */
@Service
public class AccountServiceBean implements AccountService {

  private Logger logger = LoggerFactory.getLogger(this.getClass());

  /**
   * The Spring Data repository for Account entities.
   */
  @Autowired
  private AccountRepository accountRepository;

  @Override
  public Account findByUsername(String username) {
    logger.info("> findByUsername");

    Account account = accountRepository.findByUsername(username);

    logger.info("< findByUsername");
    return account;
  }

}

package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.repositories.AccountEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class AccountService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    AccountEntityRepository repository;
}

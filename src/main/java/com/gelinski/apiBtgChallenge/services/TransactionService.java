package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import com.gelinski.apiBtgChallenge.repositories.TransactionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class TransactionService {
    private final Logger logger = Logger.getLogger(TransactionService.class.getName());

    @Autowired
    TransactionEntityRepository repository;
}

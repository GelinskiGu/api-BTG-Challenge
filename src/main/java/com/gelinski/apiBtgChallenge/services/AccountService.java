package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.repositories.AccountEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    AccountEntityRepository repository;

    public AccountEntity create(AccountEntity account) {
        logger.info("Creating one account!");

        return repository.save(account);
    }

    public List<AccountEntity> findAll() {
        logger.info("Finding all accounts!");

        return repository.findAll();
    }

    public AccountEntity findById(Long id) {
        logger.info("Finding one account!");

        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
    }

    // TODO: Implementar o update

    public void delete(Long id) {
        logger.info("Deleting one account!");

        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        repository.deleteById(id);
    }
}

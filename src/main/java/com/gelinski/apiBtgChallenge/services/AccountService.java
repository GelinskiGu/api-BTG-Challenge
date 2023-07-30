package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.mapper.AccountMapper;
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

    public AccountDTOV1 create(AccountDTOV1 account) {
        logger.info("Creating one account!");

        AccountEntity entity = AccountMapper.INSTANCE.dtoToEntity(account);
        AccountEntity savedEntity = repository.save(entity);

        return AccountMapper.INSTANCE.entityToDTO(savedEntity);
    }

    public List<AccountDTOV1> findAll() {
        logger.info("Finding all accounts!");

        return AccountMapper.INSTANCE.mapToDTO(repository.findAll());
    }

    public AccountDTOV1 findById(Long id) {
        logger.info("Finding one account!");

        AccountEntity entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        return AccountMapper.INSTANCE.entityToDTO(entity);
    }

    // TODO: Implementar o update

    public void delete(Long id) {
        logger.info("Deleting one account!");

        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        repository.deleteById(id);
    }
}

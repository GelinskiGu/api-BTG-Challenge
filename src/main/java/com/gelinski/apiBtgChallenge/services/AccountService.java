package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.mapper.AccountMapper;
import com.gelinski.apiBtgChallenge.mapper.ClientMapper;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.repositories.AccountEntityRepository;
import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    private final Logger logger = Logger.getLogger(AccountService.class.getName());

    @Autowired
    AccountEntityRepository accountRepository;

    @Autowired
    ClientEntityRepository clientRepository;

    public AccountDTOV1 create(AccountDTOV1 account) {
        logger.info("Creating one account!");

        AccountEntity entity = AccountMapper.INSTANCE.dtoToEntity(account);

        ClientDTOV1 client = ClientMapper.INSTANCE.entityToDTO(clientRepository.findById(account.getClientId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this client ID")));

        List<AccountEntity> accounts = client.getAccounts();
        accounts.add(entity);
        client.setAccounts(accounts);
        clientRepository.save(ClientMapper.INSTANCE.dtoToEntity(client));

        AccountEntity savedEntity = accountRepository.save(entity);

        return AccountMapper.INSTANCE.entityToDTO(savedEntity);
    }

    public List<AccountDTOV1> findAll() {
        logger.info("Finding all accounts!");

        return AccountMapper.INSTANCE.mapToDTO(accountRepository.findAll());
    }

    public AccountDTOV1 findById(Long id) {
        logger.info("Finding one account!");

        AccountEntity entity = accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        return AccountMapper.INSTANCE.entityToDTO(entity);
    }

    public AccountDTOV1 update(AccountDTOV1 account) {
        logger.info("Updating one account!");

        AccountEntity entity = accountRepository.findById(account.getId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this account ID"));

        entity.setStatus(account.getStatus());
        entity.setTypeAccount(account.getTypeAccount());

        AccountEntity savedEntity = accountRepository.save(entity);

        return AccountMapper.INSTANCE.entityToDTO(savedEntity);
    }

    public List<AccountDTOV1> findByClientId(Long id) {
        logger.info("Finding all accounts by client ID!");

        ClientDTOV1 client = ClientMapper.INSTANCE.entityToDTO(clientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this client ID")));

        return AccountMapper.INSTANCE.mapToDTO(client.getAccounts());
    }

    public void delete(Long id) {
        logger.info("Deleting one account!");

        accountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        accountRepository.deleteById(id);
    }
}

package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

@Service
public class ClientService {
    private final Logger logger = Logger.getLogger(ClientService.class.getName());

    @Autowired
    ClientEntityRepository repository;

    public ClientEntity create(ClientEntity client) {
        logger.info("Creating one client! " + client.getCPF());

        return repository.save(client);
    }

    public List<ClientEntity> findAll() {
        logger.info("Finding all clients!");

        return repository.findAll();
    }

    public ClientEntity findById(Long id) {
        logger.info("Finding one client!");

        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));
    }

    // TODO: Implementar o update
    public void delete(Long id) {
        logger.info("Deleting one client!");

        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        repository.deleteById(id);
    }
}

package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.mapper.ClientMapper;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private final Logger logger = Logger.getLogger(ClientService.class.getName());

    @Autowired
    ClientEntityRepository repository;

    public ClientDTOV1 create(ClientDTOV1 clientDTO) {
        logger.info("Creating one client!");

        ClientEntity clientEntity = ClientMapper.INSTANCE.dtoToEntity(clientDTO);
        ClientEntity savedClientEntity = repository.save(clientEntity);

        return ClientMapper.INSTANCE.entityToDTO(savedClientEntity);
    }

    public List<ClientDTOV1> findAll() {
        logger.info("Finding all clients!");

        return ClientMapper.INSTANCE.mapToDTO(repository.findAll());
    }

    public ClientDTOV1 findById(Long id) {
        logger.info("Finding one client!");

        return ClientMapper.INSTANCE.entityToDTO(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID")));
    }

    // TODO: Implementar o update
    public void delete(Long id) {
        logger.info("Deleting one client!");

        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        repository.deleteById(id);
    }
}

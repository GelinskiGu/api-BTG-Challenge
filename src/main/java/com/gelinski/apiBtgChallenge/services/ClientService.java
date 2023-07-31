package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.mapper.ClientMapper;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

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

    public Page<ClientDTOV1> findAll(Pageable pageable) {
        logger.info("Finding all clients!");

        var clientPage = repository.findAll(pageable);

        return clientPage.map(ClientMapper.INSTANCE::entityToDTO);
    }

    public ClientDTOV1 findById(Long id) {
        logger.info("Finding one client!");

        return ClientMapper.INSTANCE.entityToDTO(repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID")));
    }

    public ClientDTOV1 update(ClientDTOV1 clientDTO) {
        logger.info("Updating one client!");

        ClientEntity entity = repository.findById(clientDTO.getId()).orElseThrow(
            () -> new ResourceNotFoundException("No records found for this ID"));

        entity.setFullName(clientDTO.getFullName());
        entity.setCep(clientDTO.getCep());
        entity.setAdditionAddress(clientDTO.getAdditionAddress());
        entity.setBackPhotoDocument(clientDTO.getBackPhotoDocument());
        entity.setCellPhoneNumber(clientDTO.getCellPhoneNumber());
        entity.setCityAddress(clientDTO.getCityAddress());
        entity.setCityBirth(clientDTO.getCityBirth());
        entity.setCountryBirth(clientDTO.getCountryBirth());
        entity.setCpf(clientDTO.getCpf());
        entity.setDateBirth(clientDTO.getDateBirth());
        entity.setEmail(clientDTO.getEmail());
        entity.setFrontPhotoDocument(clientDTO.getFrontPhotoDocument());
        entity.setEUATaxAddress(clientDTO.getEUATaxAddress());
        entity.setIncome(clientDTO.getIncome());
        entity.setInvestments(clientDTO.getInvestments());
        entity.setMaritalStatus(clientDTO.getMaritalStatus());
        entity.setOtherNationality(clientDTO.getOtherNationality());
        entity.setIssuerDocument(clientDTO.getIssuerDocument());
        entity.setMoveableAssets(clientDTO.getMoveableAssets());
        entity.setNeighborhood(clientDTO.getNeighborhood());
        entity.setNumberAddress(clientDTO.getNumberAddress());
        entity.setNumberDocument(clientDTO.getNumberDocument());
        entity.setOtherPatrimonies(clientDTO.getOtherPatrimonies());
        entity.setProfession(clientDTO.getProfession());
        entity.setRealEstateProperties(clientDTO.getRealEstateProperties());
        entity.setRetirementFunds(clientDTO.getRetirementFunds());
        entity.setSelfiePhoto(clientDTO.getSelfiePhoto());
        entity.setStateAddress(clientDTO.getStateAddress());
        entity.setStateBirth(clientDTO.getStateBirth());
        entity.setTypeDocument(clientDTO.getTypeDocument());

        return ClientMapper.INSTANCE.entityToDTO(repository.save(entity));
    }

    public List<ClientDTOV1> findByCpf(String cpf) {
        logger.info("Finding one client by CPF!");

        List<ClientEntity> foundClients = repository.findByCpfContaining(cpf);

        if (foundClients.isEmpty()) {
            throw new ResourceNotFoundException("No records found for this CPF");
        }

        return ClientMapper.INSTANCE.mapToDTO(foundClients);
    }

    public List<ClientDTOV1> findByFullName(String fullName) {
        logger.info("Finding one client by full name!");

        List<ClientEntity> foundClients = repository.findByFullNameContaining(fullName);

        if (foundClients.isEmpty()) {
            throw new ResourceNotFoundException("No records found for this name");
        }

        return ClientMapper.INSTANCE.mapToDTO(foundClients);
    }

    public void delete(Long id) {
        logger.info("Deleting one client!");

        repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this ID"));

        repository.deleteById(id);
    }
}

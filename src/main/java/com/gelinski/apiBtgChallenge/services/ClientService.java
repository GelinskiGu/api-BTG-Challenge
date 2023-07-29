package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ClientService {
    private final Logger logger = Logger.getLogger(ClientService.class.getName());

    @Autowired
    ClientEntityRepository repository;
}

package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.repositories.OtherNationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OtherNationalityService {
    private final Logger logger = Logger.getLogger(OtherNationalityService.class.getName());

    @Autowired
    OtherNationalityRepository repository;
}

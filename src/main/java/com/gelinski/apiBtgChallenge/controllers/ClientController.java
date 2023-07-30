package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.models.ClientEntity;
import com.gelinski.apiBtgChallenge.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client/v1")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTOV1 create(@RequestBody ClientDTOV1 client) {
        return service.create(client);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClientEntity findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}

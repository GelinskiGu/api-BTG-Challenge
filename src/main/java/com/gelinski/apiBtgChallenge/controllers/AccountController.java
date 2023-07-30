package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account/v1")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDTOV1 create(@RequestBody AccountDTOV1 account) {
        return service.create(account);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AccountDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDTOV1 findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AccountDTOV1 update(@RequestBody AccountDTOV1 account) {
        return service.update(account);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
    }
}

package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.data.dto.v1.TransactionDTOV1;
import com.gelinski.apiBtgChallenge.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction/v1")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionDTOV1 create(@RequestBody TransactionDTOV1 transaction) {
        return service.create(transaction);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TransactionDTOV1 findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionDTOV1> findByAccountId(@PathVariable(value = "accountId") Long accountId) {
        return service.findByAccountId(accountId);
    }

}

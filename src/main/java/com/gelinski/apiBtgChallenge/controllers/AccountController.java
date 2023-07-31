package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account/v1")
@Tag(name = "Account", description = "Endpoints for Managing Accounts")
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Account", description = "Create a new Account by passing in a JSON representation of a Account object.",
        tags = { "Account" },
        responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                content = @Content(schema = @Schema(implementation = AccountDTOV1.class))),
            @ApiResponse(description = "Invalid Account Object", responseCode = "400",
                content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500",
                content = @Content),
        }
    )
    public AccountDTOV1 create(@RequestBody AccountDTOV1 account) {
        return service.create(account);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all Accounts", description = "List all Accounts in the database.",
        tags = { "Account" },
        responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = AccountDTOV1.class))
                )),
            @ApiResponse(description = "Bad Request", responseCode = "400",
                content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404",
                content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500",
                content = @Content),
        }
    )
    public List<AccountDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find Account by ID", description = "Find a Account in the database by ID.",
        tags = { "Account" },
        responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                content = @Content(schema = @Schema(implementation = AccountDTOV1.class))),
            @ApiResponse(description = "Bad Request", responseCode = "400",
                content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404",
                content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500",
                content = @Content),
        }
    )
    public AccountDTOV1 findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update Account", description = "Update a Account in the database by passing in a JSON representation of a Account object.",
        tags = { "Account" },
        responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200",
                content = @Content(schema = @Schema(implementation = AccountDTOV1.class))),
            @ApiResponse(description = "Invalid Account Object", responseCode = "400",
                content = @Content),
            @ApiResponse(description = "Not Found", responseCode = "404",
                content = @Content),
            @ApiResponse(description = "Internal Server Error", responseCode = "500",
                content = @Content),
        }
    )
    public AccountDTOV1 update(@RequestBody AccountDTOV1 account) {
        return service.update(account);
    }

    // TODO: Remover
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

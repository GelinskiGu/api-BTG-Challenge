package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.TransactionDTOV1;
import com.gelinski.apiBtgChallenge.services.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaction/v1")
@Tag(name = "Transaction", description = "Endpoints for Managing Transactions")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Transaction", description = "Create a new Transaction by passing in a JSON representation of a Transaction object.",
            tags = { "Transaction" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = TransactionDTOV1.class))),
                @ApiResponse(description = "Invalid Transaction Object", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Insufficient Funds", responseCode = "403",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public TransactionDTOV1 create(@RequestBody TransactionDTOV1 transaction) {
        return service.create(transaction);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all Transactions", description = "List all Transactions in the database.",
            tags = { "Transaction" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = TransactionDTOV1.class))
                        )),
                @ApiResponse(description = "Bad Request", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public List<TransactionDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find a Transaction by ID", description = "Find a Transaction by ID.",
            tags = { "Transaction" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = TransactionDTOV1.class))),
                @ApiResponse(description = "Bad Request", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public TransactionDTOV1 findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @GetMapping(value = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find all Transactions by Account ID", description = "Find all Transactions by Account ID.",
            tags = { "Transaction" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = TransactionDTOV1.class))
                        )),
                @ApiResponse(description = "Bad Request", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public List<TransactionDTOV1> findByAccountId(@PathVariable(value = "accountId") Long accountId) {
        return service.findByAccountId(accountId);
    }

}

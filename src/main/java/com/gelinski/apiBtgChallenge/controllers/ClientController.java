package com.gelinski.apiBtgChallenge.controllers;

import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.services.ClientService;
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
@RequestMapping("/api/client/v1")
@Tag(name = "Client", description = "Endpoints for Managing Clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new Client", description = "Create a new Client by passing in a JSON representation of a Client object.",
            tags = { "Client" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = ClientDTOV1.class))),
                @ApiResponse(description = "Invalid Client Object", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
        )
    public ClientDTOV1 create(@RequestBody ClientDTOV1 client) {
        return service.create(client);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "List all Clients", description = "List all Clients in the database.",
            tags = { "Client" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(
                                mediaType = "application/json",
                                array = @ArraySchema(schema = @Schema(implementation = ClientDTOV1.class))
                        )),
                @ApiResponse(description = "Bad Request", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public List<ClientDTOV1> findAll()  {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Find Client by ID", description = "Find a Client in the database by ID.",
            tags = { "Client" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = ClientDTOV1.class))),
                @ApiResponse(description = "Bad Request", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public ClientDTOV1 findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update Client", description = "Update a Client in the database by passing in a JSON representation of a Client object.",
            tags = { "Client" },
            responses = {
                @ApiResponse(description = "Successful Operation", responseCode = "200",
                        content = @Content(schema = @Schema(implementation = ClientDTOV1.class))),
                @ApiResponse(description = "Invalid Client Object", responseCode = "400",
                        content = @Content),
                @ApiResponse(description = "Not Found", responseCode = "404",
                        content = @Content),
                @ApiResponse(description = "Internal Server Error", responseCode = "500",
                        content = @Content),
            }
    )
    public ClientDTOV1 update(@RequestBody ClientDTOV1 client) {
        return service.update(client);
    }

    @GetMapping(value = "/findByCpf/{cpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTOV1> findByCpf(@PathVariable(value = "cpf") String cpf) {
        return service.findByCpf(cpf);
    }

    @GetMapping(value = "/findByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClientDTOV1> findByName(@PathVariable(value = "name") String name) {
        return service.findByFullName(name);
    }

    // TODO: Remover
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

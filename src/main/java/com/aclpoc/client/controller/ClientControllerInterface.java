package com.aclpoc.client.controller;

import java.util.List;

import com.aclpoc.client.dto.Client;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.media.MediaType;

public interface ClientControllerInterface {

    @Operation(summary = "List of Client data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Clients",
                    content = { @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Client.class))) })
    })
    List<Client> getClients();
    
//    @Operation(summary = "Delete Client data by Id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "No content",
//                    content = {})
//    })
//    void deleteClientById(long id);
}

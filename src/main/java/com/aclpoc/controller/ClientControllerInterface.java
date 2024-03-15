package com.aclpoc.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.aclpoc.dto.Client;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "jwtSecurity")
public interface ClientControllerInterface {

	@Operation(summary = "List of Client data")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Found Clients", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Client.class))) }) })
	ResponseEntity<List<Client>> getClients();

	@Operation(summary = "Create Client in DB")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "No content", content = {}) })
	public void createClient(String name, String location, LocalDate date) throws Exception;

	@Operation(summary = "Delete Client data by Id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "No content", content = {}) })
	public void deleteClientById(Long id);

}

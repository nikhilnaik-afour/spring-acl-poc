package com.aclpoc.client.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aclpoc.client.dto.Client;
import com.aclpoc.client.service.ClientService;

@RestController
@RequestMapping("api/v1/client")
public class ClientController implements ClientControllerInterface {

	private final ClientService clientService;

	public ClientController(@Qualifier("jpaService") ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	/**
	 * Get list of Clients
	 * @return
	 */
	@Override
	@GetMapping
	public List<Client> getClients() {
		List<Client> clients = clientService.getClients();
//		System.out.println(clients.get(0).getInitializationDate());
		return clients;
	}
	
	@PostMapping
	public void createClient(String name, String location, LocalDate date) {
		clientService.saveClient(new Client(name, location, date));
	}
	
//	@Override
	@DeleteMapping
	public void deleteClientById(Long id) {
		clientService.deleteClientById(id);
	}
	
	
	
}

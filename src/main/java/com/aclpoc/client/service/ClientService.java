package com.aclpoc.client.service;

import java.util.List;

import com.aclpoc.client.dto.Client;

public interface ClientService {
	List<Client> getClients();

	void saveClient(Client client);

	void deleteClientById(long id);
	
	Client getClientById(long id);
	
	void deleteAll();
}

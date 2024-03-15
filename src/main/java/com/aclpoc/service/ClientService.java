package com.aclpoc.service;

import java.util.List;

import com.aclpoc.dto.Client;

public interface ClientService {
	List<Client> getClients();

	void saveClient(Client client) throws Exception;

	void deleteClientById(long id);
	
	Client getClientById(long id);
	
	void deleteAll();
}

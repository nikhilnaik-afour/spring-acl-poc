package com.aclpoc.client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aclpoc.client.dto.Client;
import com.aclpoc.client.model.ClientJpaEntity;
import com.aclpoc.client.repository.ClientJPARepository;

@Service("jpaService")
public class ClientJPAService implements ClientService {

	@Autowired
	private ClientJPARepository clientRepository;

	@Override
	public List<Client> getClients() {
		List<Client> clientList = new ArrayList<>();
		List<ClientJpaEntity> clientEntities = clientRepository.findAll();
		clientEntities.stream().forEach(obj -> {
			Client client = new Client();
			BeanUtils.copyProperties(obj, client);
			clientList.add(client);
		});
		return clientList;
	}

	@Override
	public void saveClient(Client client) {
		ClientJpaEntity clientEntity = new ClientJpaEntity();
		BeanUtils.copyProperties(client, clientEntity);
		clientRepository.save(clientEntity);
	}

	@Override
	public void deleteClientById(long id) {
		clientRepository.deleteById(id);
	}
//
//	@Override
//	public Client getClientById() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Client getClientById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}

package com.aclpoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aclpoc.dto.Client;
import com.aclpoc.model.ClientJpaEntity;
import com.aclpoc.repository.ClientJPARepository;

@Service("jpaService")
public class ClientJPAService implements ClientService {

	@Autowired
	private ClientJPARepository clientRepository;

	@Override
//	@Secured("ROLE_ADMIN")
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
	@Secured("ROLE_ADMIN")
	@Transactional(rollbackFor = Exception.class) // rollbackFor required since by default @Transactional works only for
													// unchecked exceptions
	public void saveClient(Client client) throws Exception {
		ClientJpaEntity clientEntity = new ClientJpaEntity();
		BeanUtils.copyProperties(client, clientEntity);
		clientRepository.save(clientEntity);
		// throw new Exception(); // to test @Transactional
	}

	@Override
	public void deleteClientById(long id) {
		clientRepository.deleteById(id);
	}

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

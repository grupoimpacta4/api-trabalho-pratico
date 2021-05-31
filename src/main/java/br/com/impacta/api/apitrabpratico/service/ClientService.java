package br.com.impacta.api.apitrabpratico.service;

import br.com.impacta.api.apitrabpratico.model.Client;
import br.com.impacta.api.apitrabpratico.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

	private HashMap<String, Client> clientMap;

	@Autowired
	private ClientRepository repository;

 

	public Client addClient(Client client) { 
		repository.save(client);
		return client;
	}

	public Client updateClient(Client client) {

		Client clientData = repository.findById(client.getId());

		if (clientData != null) {

			repository.save(client);
			return client;
		}
		return null;
	}

	public Optional<Client> removeClient(int id) {

		Optional<Client> client = findById(id);
		if (!client.isEmpty()) {
			repository.delete(client.get());
		}
		return client;
	}

	public Optional<Client> findById(int clientId) {
		return Optional.ofNullable(repository.findById(clientId));
	}

	public List<Client> findByName(String name) {
		 return repository.findByName(name);
	}

	public List<Client> deleteByName(String name) {

		List<Client> clients = repository.findByName(name);

		if (clients.size() > 0) {
			for (int i = 0; i < clients.size(); i++) {
				repository.delete(clients.get(i));
			}
		}
		return clients;
	}

	public List<Client> findAllClients() {
		List<Client> clients = repository.findAll();
		return clients;
	}

}

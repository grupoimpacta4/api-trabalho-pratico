package br.com.impacta.api.apitrabpratico.config.controller;

import static br.com.impacta.api.apitrabpratico.resource.ClientResource.makeResources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.impacta.api.apitrabpratico.model.Client;
import br.com.impacta.api.apitrabpratico.service.ClientService;

@RestController
public class ClientController {
    private static final Logger LOG = LoggerFactory.getLogger(ClientController.class);

   
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "api/client/id/{clientId}", produces = { "application/hal+json" })
    public ResponseEntity<Client> getClientById(@PathVariable final int clientId) {
       System.out.println("Id"+clientId);
    	Optional<Client> client = clientService.findById(clientId);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

    
    @GetMapping(value = "api/clients/getAll", produces = { "application/hal+json" })
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAllClients();
        if(clients.size()==0){
            return ResponseEntity.notFound().build();
        }
  
        for(int i=0;i<clients.size();i++) 
        	makeResources(clients.get(i));
        
        return ResponseEntity.ok().body(clients);
    }
    
    @GetMapping(value = "api/client/name/{clientName}", produces = { "application/hal+json" })
    public ResponseEntity<List<Client>> getClientByName(@PathVariable final String clientName) {
        List<Client> clients = clientService.findByName(clientName);
        if(clients.size()==0){
            return ResponseEntity.notFound().build();
        }
  
        for(int i=0;i<clients.size();i++) 
        	makeResources(clients.get(i));
        
        return ResponseEntity.ok().body(clients);
    }

    @PutMapping(value = "api/client", produces = { "application/hal+json" })
    public ResponseEntity<Client> updateClient(@RequestBody final Client client) {
        Client newClient = clientService.updateClient(client);
        if(newClient==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(makeResources(newClient));
    }

    @PostMapping(value = "api/client", produces = { "application/hal+json" })
    public ResponseEntity<Client> newClient(@RequestBody final Client client) {
        Client newClient = clientService.addClient(client);
        return ResponseEntity.status(HttpStatus.CREATED).body(makeResources(newClient));
    }

    @DeleteMapping(value = "api/deleteClient", produces = { "application/hal+json" })
    public ResponseEntity<Object> deleteClient(@RequestBody final Client client) {
    	Optional<Client> clientF = clientService.removeClient(client.getId());
        if(clientF.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(clientF.get()));
     }

    @DeleteMapping(value = "api/client/id/{clientId}", produces = { "application/hal+json" })
    public ResponseEntity<Object> deleteClientById(@PathVariable final int clientId) {
    	Optional<Client> client = clientService.removeClient(clientId);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(makeResources(client.get()));
    }

    @DeleteMapping(value = "api/client/name/{clientName}", produces = { "application/hal+json" })
    public ResponseEntity<Object> deleteClientByName(@PathVariable final String clientName) {
         
    	List<Client> clients  = clientService.deleteByName(clientName);
        if(clients.size()==0){
            return ResponseEntity.notFound().build();
        }
        for(int i=0;i<clients.size();i++) 
        	makeResources(clients.get(i));

        return ResponseEntity.ok().body(clients);
    }
    
    
    
}

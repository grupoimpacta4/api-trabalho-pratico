package br.com.impacta.api.apitrabpratico.repository;

 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.impacta.api.apitrabpratico.model.Client;

 
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByName(String name);
	Client findById(int id);
}
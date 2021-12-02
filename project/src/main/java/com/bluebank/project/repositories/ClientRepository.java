package com.bluebank.project.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.project.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	public Optional<Client> findByCpfcnpj (String cpfcnpj);
	
	public List<Client> findByNameContaining(String nome);
	
}

package com.bluebank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.project.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByCpfcnpj (String cpfcnpj);
	
	public void deleteByCpfcnpj (String cpfcnpj);
	
}

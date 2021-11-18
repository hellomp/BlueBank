package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.project.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByCpfcnpj (String cpfcnpj);
	
	public List<Cliente> findByNomeContaining(String nome);
	
	//public void deleteByCpfcnpj (String cpfcnpj);
	
}

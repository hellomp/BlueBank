package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.project.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	public List<Conta> findByClienteId_Cpfcnpj(String cpfcnpj);
	
//	public void deleteByIdCliente_Cpfcnpj (String cpfcnpj);
}

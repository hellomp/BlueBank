package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebank.project.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	public List<Transaction> findByAccountId(Long id);
	
	public List<Transaction> findByDestinationAccountId(Long id);
	
	public List<Transaction> findByAccountId_ClientId_Cpfcnpj(String cpfcnpj);
	
	public List<Transaction> findByDestinationAccountId_ClientId_Cpfcnpj(String cpfcnpj);

}

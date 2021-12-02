package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebank.project.models.Transaction;

/**
* Interface for creating queries to the transactions table
* @author Pedro Henrique
*/
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	/**
	* Returns a list of transactions to which the given account's id matches
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  id  a unique Long value set to the entity by JPA
	* @return a list of transaction objects to which the given account's id matches the search
	*/
	public List<Transaction> findByAccountId(Long id);
	
	/**
	* Returns a list of transactions to which the given destination account's id matches
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  id  a unique Long value set to the entity by JPA
	* @return a list of transaction objects to which the given destination account's id matches the search
	*/
	public List<Transaction> findByDestinationAccountId(Long id);
	
	/**
	* Returns a list of transactions to which the given account's client cpf or cnpj matches
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  cpfcnpj  a string formed just by numbers of the client entity's cpf or cnpj attribute
	* @return a list of transactions to which the given account's client cpf or cnpj matches the search
	*/
	public List<Transaction> findByAccountId_ClientId_Cpfcnpj(String cpfcnpj);
	
	/**
	* Returns a list of transactions to which the given destination account's client cpf or cnpj attribute matches
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  cpfcnpj  a string formed just by numbers of the client entity's cpf or cnpj attribute
	* @return a list of transactions to which the given account's client cpf or cnpj matches the search
	*/
	public List<Transaction> findByDestinationAccountId_ClientId_Cpfcnpj(String cpfcnpj);

}

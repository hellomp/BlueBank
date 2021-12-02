package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebank.project.models.Account;

/**
* Interface for creating queries to the loans table
* @author Alano Menezes
*/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
	
	/**
	* Returns a list of accounts which the given cpf or cnpj matches its client
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  cpfcnpj  a string formed just by numbers of the client entity's cpf or cnpj attribute
	* @return a loan object to which the cpf or cnpj matches the search
	*/
	public List<Account> findByClientId_Cpfcnpj(String cpfcnpj);
	
}

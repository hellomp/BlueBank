package com.bluebank.project.repositories;

import java.util.List;

import com.bluebank.project.models.Loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
* Interface for creating queries to the loans table
* @author Marcos Paulo
*/
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	/**
	* Returns the loan to which the given cpf or cnpj matches its account's client
	* containing all the corresponding database table's columns data into its attributes
	* 
	* @param  cpfcnpj  a string formed just by numbers of the client entity's cpf or cnpj attribute
	* @return a loan object to which the cpf or cnpj matches the search
	*/
	public List<Loan> findByClientId_Cpfcnpj(String cpfcnpj);
  
}

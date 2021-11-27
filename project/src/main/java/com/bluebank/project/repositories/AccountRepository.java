package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bluebank.project.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	public List<Account> findByClientId_Cpfcnpj(String cpfcnpj);
	
}

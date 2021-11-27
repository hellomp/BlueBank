package com.bluebank.project.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.models.Account;

@Service
public class AccountMapper {
	
	@Autowired
	ClientMapper clientMapper;
	
	public AccountDTO updateDtoFromAccount(Account account, AccountDTO accountDTO) {
		
		accountDTO.setId(account.getId());
		accountDTO.setClientName(account.getClient().getName());
		accountDTO.setAgency(account.getAgency());
		accountDTO.setAccountType(account.getAccountType());
		
		if(account.getStatus().equals(AccountStatusEnum.Inativa)) {
			String status = "Conta inativa desde " + account.getDateForReference().toString();
			accountDTO.setStatus(status);
			
		} else if(account.getStatus().equals(AccountStatusEnum.Ativa)) {
			String status = "Conta ativa desde: " + account.getDateForReference().toString();
			accountDTO.setStatus(status);
			
		}
		accountDTO.setCurrentBalance(account.getBalance());
		
		return accountDTO;
	}

}
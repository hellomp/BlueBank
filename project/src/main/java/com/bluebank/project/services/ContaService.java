package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.mappers.AccountMapper;
import com.bluebank.project.models.Client;
import com.bluebank.project.models.Account;
import com.bluebank.project.repositories.ClientRepository;
import com.bluebank.project.repositories.AccountRepository;

@Service
public class ContaService {

	@Autowired
	AccountRepository contaRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AccountMapper accountMapper;
	
	@Transactional
	public AccountDTO cadastrarNovaConta(String cpfcnpj, Account conta) {
		conta.setClient(clientRepository.findByCpfcnpj(cpfcnpj));
		conta.setDateForReference(java.util.Calendar.getInstance().getTime());
		conta.setStatus(AccountStatusEnum.Ativa);
		
		AccountDTO accountDTOAux = new AccountDTO();
		accountMapper.updateDtoFromAccount(contaRepository.save(conta), accountDTOAux);
		return accountDTOAux;
	}
	
	@Transactional
	public AccountDTO consultarCadastroContaId(Long id) throws IllegalArgumentException {
		Account contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		return accountMapper.updateDtoFromAccount(contaAux, new AccountDTO());
	}
	
	@Transactional
	public List<AccountDTO> consultarCadastrosContaCpfcnpj(String cpfcnpj) throws IllegalArgumentException {
		List<AccountDTO> listAccountDTOAux = new ArrayList<AccountDTO>();
		for (Account conta : contaRepository.findByClientId_Cpfcnpj(cpfcnpj)) {
			listAccountDTOAux.add(accountMapper.updateDtoFromAccount(conta, new AccountDTO()));
		}
		return listAccountDTOAux;
	}
	
	@Transactional
	public AccountDTO AlterarTitularContaId(Long id, String cpfcnpj) throws IllegalArgumentException {
		Account contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		Client clienteAux = clientRepository.findByCpfcnpj(cpfcnpj);
		contaAux.setClient(clienteAux);
//		contaRepository.save(contaAux);
		return accountMapper.updateDtoFromAccount(contaRepository.save(contaAux), new AccountDTO());
	}

	@Transactional
	public void desativarContaId(Long id) {
		Account contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		contaAux.setStatus(AccountStatusEnum.Inativa);
		contaAux.setDateForReference(java.util.Calendar.getInstance().getTime());
		contaRepository.save(contaAux);
	}
	
	@Transactional
	public void desativarContasCpfcnpj(String cpfcnpj) {
		List<Account> listContaAux = contaRepository.findByClientId_Cpfcnpj(cpfcnpj);
		for (Account contaAux : listContaAux) {
			contaAux.setStatus(AccountStatusEnum.Inativa);
			contaAux.setDateForReference(java.util.Calendar.getInstance().getTime());
			contaRepository.save(contaAux);			
		}
	}
}

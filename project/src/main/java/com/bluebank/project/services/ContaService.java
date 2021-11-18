package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.mappers.ContaMapper;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.models.Conta;
import com.bluebank.project.repositories.ClienteRepository;
import com.bluebank.project.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	ClienteRepository clientRepository;
	
	@Autowired
	ContaMapper accountMapper;
	
	@Transactional
	public AccountDTO cadastrarNovaConta(String cpfcnpj, Conta conta) {
		conta.setCliente(clientRepository.findByCpfcnpj(cpfcnpj));
		conta.setDateForReference(java.util.Calendar.getInstance().getTime());
		conta.setStatus(AccountStatusEnum.Ativa);
		
		AccountDTO accountDTOAux = new AccountDTO();
		accountMapper.updateDtoFromAccount(conta, accountDTOAux); // bug do id
		contaRepository.save(conta);
		return accountDTOAux;
	}
	
	@Transactional
	public AccountDTO consultarCadastroContaId(Long id) throws IllegalArgumentException {
		Conta contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		return accountMapper.updateDtoFromAccount(contaAux, new AccountDTO());
	}
	
	@Transactional
	public List<AccountDTO> consultarCadastrosContaCpfcnpj(String cpfcnpj) throws IllegalArgumentException {
		List<AccountDTO> listAccountDTOAux = new ArrayList<AccountDTO>();
		for (Conta conta : contaRepository.findByClienteId_Cpfcnpj(cpfcnpj)) {
			listAccountDTOAux.add(accountMapper.updateDtoFromAccount(conta, new AccountDTO()));
		}
		return listAccountDTOAux;
	}
	
	@Transactional
	public AccountDTO AlterarTitularContaId(Long id, String cpfcnpj) throws IllegalArgumentException {
		Conta contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		Cliente clienteAux = clientRepository.findByCpfcnpj(cpfcnpj);
		contaAux.setCliente(clienteAux);
		return accountMapper.updateDtoFromAccount(contaAux, new AccountDTO());
	}
	
//	@Transactional
//	public Conta atualizarCadastroConta(String cpfcnpj, AccountDTO accountDTO) {
//	    Conta contaAux = consultarCadastroConta(cpfcnpj);
//	    accountMapper.updateAccountFromDto(accountDTO, contaAux);
//		return contaRepository.save(contaAux);
//	}

	@Transactional
	public void desativarContaId(Long id) {
		// mudar status
		Conta contaAux = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		contaAux.setStatus(AccountStatusEnum.Inativa);
		contaAux.setDateForReference(java.util.Calendar.getInstance().getTime());
		contaRepository.save(contaAux);
	}
	
	@Transactional
	public void desativarContasCpfcnpj(String cpfcnpj) {
		// mudar status
		List<Conta> listContaAux = contaRepository.findByClienteId_Cpfcnpj(cpfcnpj);
		for (Conta contaAux : listContaAux) {
			contaAux.setStatus(AccountStatusEnum.Inativa);
			contaAux.setDateForReference(java.util.Calendar.getInstance().getTime());
			contaRepository.save(contaAux);			
		}
	}
}

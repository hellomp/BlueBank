package com.bluebank.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.mappers.ContaMapper;
import com.bluebank.project.models.Conta;
import com.bluebank.project.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;
	
	@Autowired
	ContaMapper accountMapper;
	
	@Transactional
	public Conta cadastrarNovaConta(Conta conta) {
		return contaRepository.save(conta);
	}
	
	@Transactional
	public Conta consultarCadastroConta(Long id) throws IllegalArgumentException {
		return contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
	}
	
	@Transactional
	public Conta consultarCadastroConta(String cpfcnpj) throws IllegalArgumentException {
		return contaRepository.findByClienteId_Cpfcnpj(cpfcnpj);
	}
	
	@Transactional
	public Conta atualizarCadastroConta(String cpfcnpj, AccountDTO accountDTO) {
	    Conta contaAux = consultarCadastroConta(cpfcnpj);
	    accountMapper.updateAccountFromDto(accountDTO, contaAux);
		return contaRepository.save(contaAux);
	}

	@Transactional
	public void excluirConta(Long id) {
		// mudar status
		contaRepository.deleteById(id);
	}
}

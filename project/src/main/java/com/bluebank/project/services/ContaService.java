package com.bluebank.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.mappers.ClienteUpdater;
import com.bluebank.project.mappers.ContaMapper;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.models.Conta;
import com.bluebank.project.repositories.ClienteRepository;
import com.bluebank.project.repositories.ContaRepository;

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
	public Conta atualizarCadastroConta(Long id, AccountDTO accountDTO) {
	    Conta contaAux = consultarCadastroConta(id);
	    accountMapper.updateAccountFromDto(accountDTO, contaAux);
		return contaRepository.save(contaAux);
	}

	@Transactional
	public void excluirConta(Long id) {
		// mudar status
		contaRepository.deleteById(id);
	}
}

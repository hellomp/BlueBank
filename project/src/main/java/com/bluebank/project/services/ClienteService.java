package com.bluebank.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.mappers.ClienteUpdater;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteUpdater clienteUpdaterMapper;
	
	@Transactional
	public Cliente cadastrarNovoCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public Cliente consultarCadastroCliente(String cpfcnpj){
		return clienteRepository.findByCpfcnpj(cpfcnpj);
	}
	
	@Transactional
	public Cliente atualizarCadastroCliente(String cpfcnpj, ClientDTO clientDTO) {//(String cpfcnpj, Cliente cliente){ // 
//		Cliente clienteAux = consultarCadastroCliente(cpfcnpj);
//		clienteAux

	    Cliente clienteAux = clienteRepository.findByCpfcnpj(cpfcnpj);
	    clienteUpdaterMapper.updateClientFromDto(clientDTO, clienteAux);
		return clienteRepository.save(clienteAux);
	}

	@Transactional
	public void excluirContaCliente(String cpfcnpj){
		clienteRepository.deleteByCpfcnpj(cpfcnpj);
	}

}

package com.bluebank.project.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.mappers.ClienteUpdater;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.repositories.ClienteRepository;

public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteUpdater clienteUpdaterMapper;
	
	public Cliente cadastrarNovoCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente consultarCadastroCliente(String cpfcnpj){
		return clienteRepository.findByCpfcnpj(cpfcnpj);
	}
	
	public Cliente atualizarCadastroCliente(ClientDTO clientDTO) {//(String cpfcnpj, Cliente cliente){ // 
//		Cliente clienteAux = consultarCadastroCliente(cpfcnpj);
//		clienteAux

	    Cliente clienteAux = clienteRepository.findByCpfcnpj(clientDTO.getCpfcnpj());
	    clienteUpdaterMapper.updateClientFromDto(clientDTO, clienteAux);
		return clienteRepository.save(clienteAux);
	}
	
	public void excluirContaCliente(String cpfcnpj){
		clienteRepository.deleteByCpfcnpj(cpfcnpj);
	}

}

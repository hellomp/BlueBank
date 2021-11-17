package com.bluebank.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.mappers.ClientMapper;
import com.bluebank.project.mappers.ClientMapperImpl;
import com.bluebank.project.models.Cliente;
import com.bluebank.project.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClientMapperImpl clientMapper;
	
	@Transactional
	public ClientDTO cadastrarNovoCliente(Cliente cliente) {
		ClientDTO clientDTO = new ClientDTO();
		clientMapper.updateDtoFromClient(cliente, clientDTO);
		clienteRepository.save(cliente);
		return clientDTO;
	}
	
	@Transactional
	public ClientDTO consultarCadastroCliente(String cpfcnpj){
		ClientDTO clientDTO = new ClientDTO();
		clientMapper.updateDtoFromClient(clienteRepository.findByCpfcnpj(cpfcnpj), clientDTO);
		return clientDTO;
	}
	
	@Transactional
	public ClientDTO atualizarCadastroCliente(String cpfcnpj, ClientDTO clientDTO) {//(String cpfcnpj, Cliente cliente){ // 
//		Cliente clienteAux = consultarCadastroCliente(cpfcnpj);
//		clienteAux

	    Cliente clienteAux = clienteRepository.findByCpfcnpj(cpfcnpj);
	    clientMapper.updateClientFromDto(clientDTO, clienteAux);
	    clientMapper.updateDtoFromClient(clienteAux, clientDTO);
		return clientDTO;
	}

	@Transactional
	public void excluirContaCliente(String cpfcnpj){
		clienteRepository.deleteByCpfcnpj(cpfcnpj);
	}

}

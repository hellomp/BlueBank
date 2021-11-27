package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.enums.ClientStatusEnum;
import com.bluebank.project.mappers.ClientMapper;
import com.bluebank.project.models.Client;
import com.bluebank.project.repositories.ClientRepository;

@Service
public class ClienteService {

	@Autowired
	ClientRepository clienteRepository;
	
	@Autowired
	ClientMapper clientMapper;
	
	@Autowired
	ContaService contaService;
	
	@Transactional
	public ClientDTO registerNewClient(Client cliente) {
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
	public List<ClientDTO> buscarClientePorNome(String nome){
		List<Client> listClientAux = clienteRepository.findByNameContaining(nome);
		List<ClientDTO> listClientDTOAux = new ArrayList<>();
		for(Client clientAux : listClientAux) {
			listClientDTOAux.add(clientMapper.updateDtoFromClient(clientAux, new ClientDTO()));
		}
		return listClientDTOAux;
	}
	
	@Transactional
	public ClientDTO atualizarCadastroCliente(String cpfcnpj, ClientDTO clientDTO) {
	    Client clienteAux = clienteRepository.findByCpfcnpj(cpfcnpj);
	    clientMapper.updateClientFromDto(clientDTO, clienteAux);
	    clientMapper.updateDtoFromClient(clienteAux, clientDTO);
	    clienteRepository.save(clienteAux);
		return clientDTO;
	}

	@Transactional
	public void desativarContaCliente(String cpfcnpj){
		Client clientAux = clienteRepository.findByCpfcnpj(cpfcnpj);
		clientAux.setStatus(ClientStatusEnum.Inativo);
		contaService.desativarContasCpfcnpj(cpfcnpj);
		clienteRepository.save(clientAux);
	}

}

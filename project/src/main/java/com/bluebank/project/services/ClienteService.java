package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.enums.ClientStatusEnum;
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
	
	@Autowired
	ContaService contaService;
	
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
	public List<ClientDTO> buscarClientePorNome(String nome){
		List<Cliente> listClientAux = clienteRepository.findByNomeContaining(nome);
		List<ClientDTO> listClientDTOAux = new ArrayList<>();
		for(Cliente clientAux : listClientAux) {
			listClientDTOAux.add(clientMapper.updateDtoFromClient(clientAux, new ClientDTO()));
		}
		return listClientDTOAux;
	}
	
	@Transactional
	public ClientDTO atualizarCadastroCliente(String cpfcnpj, ClientDTO clientDTO) {
	    Cliente clienteAux = clienteRepository.findByCpfcnpj(cpfcnpj);
	    clientMapper.updateClientFromDto(clientDTO, clienteAux);
	    clientMapper.updateDtoFromClient(clienteAux, clientDTO);
		return clientDTO;
	}

	@Transactional
	public void desativarContaCliente(String cpfcnpj){
		Cliente clientAux = clienteRepository.findByCpfcnpj(cpfcnpj);
		clientAux.setStatus(ClientStatusEnum.Inativo);
		contaService.desativarContasCpfcnpj(cpfcnpj);
	}

}

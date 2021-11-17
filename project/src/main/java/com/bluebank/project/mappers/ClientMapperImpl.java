package com.bluebank.project.mappers;

import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.models.Cliente;

@Service
public class ClientMapperImpl {

//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public void updateClientFromDto(ClientDTO clientDTO, @MappingTarget Cliente cliente) {
		if (!clientDTO.getCpfcnpj().isBlank()) cliente.setCpfcnpj(clientDTO.getCpfcnpj());
		if (!clientDTO.getNome().isBlank()) cliente.setNome(clientDTO.getNome());
		if (!clientDTO.getEmail().isBlank()) cliente.setEmail(clientDTO.getEmail());
		if (!clientDTO.getCep().isBlank()) cliente.setCep(clientDTO.getCep());
		if (!clientDTO.getTelefone().isBlank()) cliente.setTelefone(clientDTO.getTelefone());
		if (!clientDTO.getTipo().isBlank()) cliente.setTipo(clientDTO.getTipo());
	}
	
	
	public void updateDtoFromClient(Cliente client, @MappingTarget ClientDTO clientDTO) {
		clientDTO.setCpfcnpj(client.getCpfcnpj());
		clientDTO.setNome(client.getNome());
		clientDTO.setEmail(client.getEmail());
		clientDTO.setCep(client.getCep());
		clientDTO.setTelefone(client.getTelefone());
		clientDTO.setTipo(client.getTipo());
	}

}
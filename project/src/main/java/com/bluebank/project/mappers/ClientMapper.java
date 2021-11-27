package com.bluebank.project.mappers;

import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.models.Client;

@Service
public class ClientMapper {

//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	public Client updateClientFromDto(ClientDTO clientDTO, Client client) {
		if (!clientDTO.getCpfcnpj().isBlank()) client.setCpfcnpj(clientDTO.getCpfcnpj());
		if (!clientDTO.getName().isBlank()) client.setName(clientDTO.getName());
		if (!clientDTO.getEmail().isBlank()) client.setEmail(clientDTO.getEmail());
		if (!clientDTO.getCep().isBlank()) client.setCep(clientDTO.getCep());
		if (!clientDTO.getPhoneNumber().isBlank()) client.setPhoneNumber(clientDTO.getPhoneNumber());
		if (!clientDTO.getType().isBlank()) client.setType(clientDTO.getType());
		
		return client;
	}
	
	
	public ClientDTO updateDtoFromClient(Client client, ClientDTO clientDTO) {
		clientDTO.setCpfcnpj(client.getCpfcnpj());
		clientDTO.setName(client.getName());
		clientDTO.setEmail(client.getEmail());
		clientDTO.setCep(client.getCep());
		clientDTO.setPhoneNumber(client.getPhoneNumber());
		clientDTO.setType(client.getType());
		
		return clientDTO;
	}

}
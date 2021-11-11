package com.bluebank.project.mappers;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.models.Cliente;

public class ClientMapper {

	public ClientDTO toDto(Cliente cliente) {
//        String name = user.getName();
//        List<String> roles = user
//          .getRoles()
//          .stream()
//          .map(Role::getName)
//          .collect(toList());

//        return new UserDTO(name, roles);
		return new ClientDTO();
    }

    public Cliente toClient(ClientDTO clientDTO) {
//        return new User(userDTO.getName(), userDTO.getPassword(), new ArrayList<>());
    	return new Cliente();
    }

}

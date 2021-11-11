package com.bluebank.project.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bluebank.project.dtos.ClientDTO;
import com.bluebank.project.models.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteUpdater {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateClientFromDto(ClientDTO clientDTO, @MappingTarget Cliente cliente);
	
	void updateDtoFromClient(Cliente cliente, @MappingTarget ClientDTO clientDTO);

}
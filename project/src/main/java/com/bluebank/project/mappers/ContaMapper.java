package com.bluebank.project.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bluebank.project.dtos.AccountDTO;
import com.bluebank.project.models.Conta;

@Mapper(componentModel = "spring")
public interface ContaMapper {

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateAccountFromDto(AccountDTO accountDTO, @MappingTarget Conta conta);
	
	void updateDtoFromAccount(Conta conta, @MappingTarget AccountDTO clientDTO);

}

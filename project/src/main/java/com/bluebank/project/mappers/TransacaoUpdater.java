package com.bluebank.project.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.bluebank.project.dtos.TransacaoDTO;
import com.bluebank.project.models.Transacao;

//@Mapper(componentModel = "spring")
public interface TransacaoUpdater {
	
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateTransacaoFromDto(TransacaoDTO transacaoDTO, @MappingTarget Transacao transacao);
	
	void updateDtoFromTransacao(Transacao transacao, @MappingTarget TransacaoDTO transacaoDTO);
}

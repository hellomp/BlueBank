package com.bluebank.project.mappers;

import org.mapstruct.MappingTarget;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.dtos.TransacaoDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.models.Transacao;

//@Mapper(componentModel = "spring")
public interface TransacaoMapper {
	
//	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	void updateTransacaoFromDto(TransacaoDTO transacaoDTO, @MappingTarget Transacao transacao);
	void updateDtoFromTransacao(Transacao transacao, @MappingTarget TransacaoDTO transacaoDTO);
	
	void updateTransacaoFromDepositoDto(DepositoDTO depositoDTO, @MappingTarget Transacao transacao);
	void updateDepositoDtoFromTransacao(Transacao transacao, @MappingTarget DepositoDTO depositoDTO);
	
	void updateTransacaoFromEmprestimoDto(EmprestimoDTO emprestimoDTO, @MappingTarget Transacao transacao);
	void updateEmprestimoDtoFromTransacao(Transacao transacao, @MappingTarget EmprestimoDTO emprestimoDTO);
	
	void updateTransacaoFromSaqueDto(SaqueDTO saqueDTO, @MappingTarget Transacao transacao);
	void updateSaqueDtoFromTransacao(Transacao transacao, @MappingTarget SaqueDTO saqueDTO);
	
	void updateTransacaoFromTransferenciaDto(TransferenciaDTO transferenciaDTO, @MappingTarget Transacao transacao);
	void updateTransferenciaDtoFromTransacao(Transacao transacao, @MappingTarget TransferenciaDTO transferenciaDTO);
}

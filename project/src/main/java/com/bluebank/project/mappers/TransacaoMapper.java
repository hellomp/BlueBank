package com.bluebank.project.mappers;

import com.bluebank.project.dtos.TransacaoDTO;
import com.bluebank.project.models.Transacao;

public class TransacaoMapper {
	public TransacaoDTO toDto(Transacao transacao) {
		return new TransacaoDTO();
	}
	
	public Transacao toTransacao(TransacaoDTO transacaoDTO) {
		return new Transacao(); 
	}
}

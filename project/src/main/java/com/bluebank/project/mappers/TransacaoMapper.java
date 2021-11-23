package com.bluebank.project.mappers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.models.Transacao;

@Service
public class TransacaoMapper {

//	public Transacao updateTransacaoFromDto(TransacaoDTO transacaoDTO, Transacao transacao) {
//	}
	public List <Object> updateDtoFromTransacoes(List <Transacao> transacoes) {
//		transacaoDTO.setConta(transacao.getConta());
//		transacaoDTO.setTipoTransacao(transacao.getTipoTransacao());
//		transacaoDTO.setDataTransacao(transacao.getDataTransacao());
//		transacaoDTO.setSaldoAnterior(transacao.getSaldoAnterior());
//		transacaoDTO.setSaldoAtual(transacao.getSaldoAtual());
//		transacaoDTO.setContaDestino(transacao.getContaDestino());
//		transacaoDTO.setDataAgendTransacao(transacao.getDataAgendTransacao());
//		transacaoDTO.setDataExecTransacao(transacao.getDataExecTransacao());
//		transacaoDTO.setEmprestimo(transacao.getEmprestimo());
//		transacaoDTO.setDepositoEmprestimo(transacao.getDepositoEmprestimo());
//		transacaoDTO.setValor(transacao.getValor());
//		return transacaoDTO;
		List <Object> transacoesDTO = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			if(transacao.getTipoTransacao() == TipoTransacao.DEP ) {
				DepositoDTO depositoDTO = new DepositoDTO();
				updateDepositoDtoFromTransacao(transacao, depositoDTO);
				transacoesDTO.add(depositoDTO);
			} else if(transacao.getTipoTransacao() == TipoTransacao.SAQ) {
				SaqueDTO saqueDTO = new SaqueDTO();
				updateSaqueDtoFromTransacao(transacao, saqueDTO);
				transacoesDTO.add(saqueDTO);
			} else if(transacao.getTipoTransacao() == TipoTransacao.TRA) {
				TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
				updateTransferenciaDtoFromTransacao(transacao, transferenciaDTO);
				transacoesDTO.add(transacoesDTO);
			}
		}
		return transacoesDTO;
		
	}
	
//	public Transacao updateTransacaoFromDepositoDto(DepositoDTO depositoDTO, Transacao transacao) {
//	}	
	public DepositoDTO updateDepositoDtoFromTransacao(Transacao transacao,DepositoDTO depositoDTO) {
//		depositoDTO.setConta(transacao.getConta());
		depositoDTO.setDataTransacao(transacao.getDataTransacao());
		depositoDTO.setTipoTransacao(transacao.getTipoTransacao());
		depositoDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		depositoDTO.setSaldoAtual(transacao.getSaldoAtual());
		depositoDTO.setValorDeposito(transacao.getValor());
		return depositoDTO;
	}

//	public Transacao updateTransacaoFromSaqueDto(SaqueDTO saqueDTO,Transacao transacao){
//}
	public SaqueDTO updateSaqueDtoFromTransacao(Transacao transacao, SaqueDTO saqueDTO) {
//		saqueDTO.setConta(transacao.getConta());
		saqueDTO.setTipoTransacao(transacao.getTipoTransacao());
		saqueDTO.setDataTransacao(transacao.getDataTransacao());
		saqueDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		saqueDTO.setSaldoAtual(transacao.getSaldoAtual());
		saqueDTO.setValorSaque(transacao.getValor());
		return saqueDTO;
	}

//	public Transacao updateTransacaoFromTransferenciaDto(TransferenciaDTO transferenciaDTO, @MappingTarget Transacao transacao){
//}
	public TransferenciaDTO updateTransferenciaDtoFromTransacao(Transacao transacao, TransferenciaDTO transferenciaDTO) {
		transferenciaDTO.setConta(transacao.getConta());
		transferenciaDTO.setTipoTransacao(transacao.getTipoTransacao());
		transferenciaDTO.setDataTransacao(transacao.getDataTransacao());
		transferenciaDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		transferenciaDTO.setSaldoAtual(transacao.getSaldoAtual());
		transferenciaDTO.setContaDestino(transacao.getContaDestino());
		transferenciaDTO.setDataAgendTransacao(transacao.getDataAgendTransacao());
		transferenciaDTO.setDataExecTransacao(transacao.getDataExecTransacao());
		transferenciaDTO.setValor(transacao.getValor());
		return transferenciaDTO;
	}

}





package com.bluebank.project.mappers;



import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.dtos.TransacaoDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;

@Service
public class TransacaoMapper {

//	public Transacao updateTransacaoFromDto(TransacaoDTO transacaoDTO, Transacao transacao) {
//	}
	public TransacaoDTO updateDtoFromTransacao(Transacao transacao, TransacaoDTO transacaoDTO) {
		transacaoDTO.setConta(transacao.getConta());
		transacaoDTO.setTipoTransacao(transacao.getTipoTransacao());
		transacaoDTO.setDataTransacao(transacao.getDataTransacao());
		transacaoDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		transacaoDTO.setSaldoAtual(transacao.getSaldoAtual());
		transacaoDTO.setContaDestino(transacao.getContaDestino());
		transacaoDTO.setDataAgendTransacao(transacao.getDataAgendTransacao());
		transacaoDTO.setDataExecTransacao(transacao.getDataExecTransacao());
		transacaoDTO.setEmprestimo(transacao.getEmprestimo());
		transacaoDTO.setDepositoEmprestimo(transacao.getDepositoEmprestimo());
		return transacaoDTO;
		
	}
	
//	public Transacao updateTransacaoFromDepositoDto(DepositoDTO depositoDTO, Transacao transacao) {
//	}	
	public DepositoDTO updateDepositoDtoFromTransacao(Transacao transacao,DepositoDTO depositoDTO) {
		depositoDTO.setConta(transacao.getConta());
		depositoDTO.setDataTransacao(transacao.getDataTransacao());
		depositoDTO.setTipoTransacao(transacao.getTipoTransacao());
		depositoDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		depositoDTO.setSaldoAtual(transacao.getSaldoAtual());
		return depositoDTO;
	}

	
//	public Emprestimo updateEmprestimoFromEmprestimoDto(EmprestimoDTO emprestimoDTO, Emprestimo emprestimo) {	
//	}
	public EmprestimoDTO updateEmprestimoDtoFromEmprestimo(Emprestimo emprestimo, EmprestimoDTO emprestimoDTO) {
		emprestimoDTO.setNumeroContrato(emprestimo.getNumeroContrato());
		emprestimoDTO.setDataInicio(emprestimo.getDataInicio());
		emprestimoDTO.setDataFim(emprestimo.getDataFim());
		emprestimoDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoDTO.setPercentualJuros(emprestimo.getPercentualJuros());
		emprestimoDTO.setQuantParcelas(emprestimo.getQuantParcelas());
		return emprestimoDTO;
	}
	
	
	
//	public Transacao updateTransacaoFromSaqueDto(SaqueDTO saqueDTO,Transacao transacao){
//}
	public SaqueDTO updateSaqueDtoFromTransacao(Transacao transacao, SaqueDTO saqueDTO) {
		saqueDTO.setConta(transacao.getConta());
		saqueDTO.setTipoTransacao(transacao.getTipoTransacao());
		saqueDTO.setDataTransacao(transacao.getDataTransacao());
		saqueDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		saqueDTO.setSaldoAtual(transacao.getSaldoAtual());
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
		return transferenciaDTO;
	}

}





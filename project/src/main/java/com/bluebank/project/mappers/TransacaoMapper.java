package com.bluebank.project.mappers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;

@Service
public class TransacaoMapper {

//	public Transacao updateTransacaoFromDto(TransacaoDTO transacaoDTO, Transacao transacao) {
//	}
	public List <Object> updateDtoFromTransacoes(List <Transacao> transacoes) {
		List <Object> transacoesDTO = new ArrayList<>();
		for (Transacao transacao : transacoes) {
			switch (transacao.getTipoTransacao()) {
			case DEP:
				DepositoDTO depositoDTO = new DepositoDTO();
				updateDepositoDtoFromTransacao(transacao, depositoDTO);
				transacoesDTO.add(depositoDTO);
				break;
			case SAQ:
				SaqueDTO saqueDTO = new SaqueDTO();
				updateSaqueDtoFromTransacao(transacao, saqueDTO);
				transacoesDTO.add(saqueDTO);
				break;
			case TRA:
				TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
				updateTransferenciaDtoFromTransacao(transacao, transferenciaDTO);
				transacoesDTO.add(transacoesDTO);
				break;
			}		
		}
		return transacoesDTO;
	}	
//			if(transacao.getTipoTransacao() == TipoTransacao.DEP ) {
//				DepositoDTO depositoDTO = new DepositoDTO();
//				updateDepositoDtoFromTransacao(transacao, depositoDTO);
//				transacoesDTO.add(depositoDTO);
//			} else if(transacao.getTipoTransacao() == TipoTransacao.SAQ) {
//				SaqueDTO saqueDTO = new SaqueDTO();
//				updateSaqueDtoFromTransacao(transacao, saqueDTO);
//				transacoesDTO.add(saqueDTO);
//			} else if(transacao.getTipoTransacao() == TipoTransacao.TRA) {
//				TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
//				updateTransferenciaDtoFromTransacao(transacao, transferenciaDTO);
//				transacoesDTO.add(transacoesDTO);
//			}
//		}
		
	
//	public Transacao updateTransacaoFromDepositoDto(DepositoDTO depositoDTO, Transacao transacao) {
//	}	
	public DepositoDTO updateDepositoDtoFromTransacao(Transacao transacao,DepositoDTO depositoDTO) {
//		depositoDTO.setConta(transacao.getConta());
		depositoDTO.setDataTransacao(transacao.getDataTransacao().toString());
		depositoDTO.setTipoTransacao(transacao.getTipoTransacao());
		depositoDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		depositoDTO.setSaldoAtual(transacao.getSaldoAtual());
		depositoDTO.setValorDeposito(transacao.getValor());
		return depositoDTO;
	}


//	public Emprestimo updateEmprestimoFromEmprestimoDto(EmprestimoDTO emprestimoDTO, Emprestimo emprestimo) {	
//	}
	public EmprestimoDTO updateEmprestimoDtoFromEmprestimo(Emprestimo emprestimo, EmprestimoDTO emprestimoDTO) {
		emprestimoDTO.setNumeroContrato(emprestimo.getNumeroContrato());
		emprestimoDTO.setDataInicio(emprestimo.getDataInicio().toString());
		emprestimoDTO.setDataFim(emprestimo.getDataFim().toString());
		emprestimoDTO.setValorEmprestimo(emprestimo.getValorEmprestimo());
		emprestimoDTO.setPercentualJuros(emprestimo.getPercentualJuros());
		emprestimoDTO.setQuantParcelas(emprestimo.getQuantParcelas());
		return emprestimoDTO;
	}
	
//	public Transacao updateTransacaoFromSaqueDto(SaqueDTO saqueDTO,Transacao transacao){
//}
	public SaqueDTO updateSaqueDtoFromTransacao(Transacao transacao, SaqueDTO saqueDTO) {
//		saqueDTO.setConta(transacao.getConta());
		saqueDTO.setTipoTransacao(transacao.getTipoTransacao());
		saqueDTO.setDataTransacao(transacao.getDataTransacao().toString());
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
		transferenciaDTO.setDataTransacao(transacao.getDataTransacao().toString());
		transferenciaDTO.setSaldoAnterior(transacao.getSaldoAnterior());
		transferenciaDTO.setSaldoAtual(transacao.getSaldoAtual());
		transferenciaDTO.setContaDestino(transacao.getContaDestino());
		transferenciaDTO.setDataAgendTransacao(transacao.getDataAgendTransacao().toString());
		transferenciaDTO.setDataExecTransacao(transacao.getDataExecTransacao().toString());
		transferenciaDTO.setValor(transacao.getValor());
		return transferenciaDTO;
	}

}

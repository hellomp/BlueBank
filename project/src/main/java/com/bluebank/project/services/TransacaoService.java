package com.bluebank.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.dtos.TransferenciaDTO;
import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.mappers.TransacaoMapper;
import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.ClienteRepository;
import com.bluebank.project.repositories.ContaRepository;
import com.bluebank.project.repositories.TransacaoRepository;

@Service
public class TransacaoService {

  @Autowired
  TransacaoRepository transacaoRepository;
  
  @Autowired
  ContaRepository contaRepository;

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  TransacaoMapper transacaoMapper;

  @Transactional
  public List<Transacao> findAll(){
    return this.transacaoRepository.findAll();
  }

  @Transactional
  public List<Transacao> findByCpfCnpj(String cpfcnpj){
    return this.transacaoRepository.findByContaId_ClienteId_Cpfcnpj(cpfcnpj);
  }
  
  @Transactional
  public Transacao criarTransacao(Transacao transacao){
    return this.transacaoRepository.save(transacao);
  }

  public List<Object> findByContaId(Long id){
		List <Transacao> transacoes = transacaoRepository.findByContaId(id);
		return transacaoMapper.updateDtoFromTransacoes(transacoes);
	}
	
	public double findSaldo(Long id) {
		Conta conta = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		return conta.getSaldo();
	}

	public SaqueDTO criarSaque(Long id, Transacao transacao) {
		transacao.setConta(contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTipoTransacao(TipoTransacao.SAQ);
		transacao.setDataTransacao(java.util.Calendar.getInstance().getTime());
		transacao.setSaldoAnterior(transacao.getConta().getSaldo());
		transacao.setSaldoAtual(transacao.getConta().getSaldo());
		transacao.setValor(transacao.getValor());
		SaqueDTO saqueDTO = new SaqueDTO();
		double valorSaque = transacao.getValor();
		if (valorSaque >= transacao.getSaldoAtual()) {
			throw new IllegalArgumentException("Valor de saque maior que o saldo disponível");
		} else {
			Conta conta = transacao.getConta();
			conta.setSaldo(conta.getSaldo() - valorSaque);
			transacao.setSaldoAtual(conta.getSaldo());
		}
		transacaoMapper.updateSaqueDtoFromTransacao(transacao, saqueDTO);
		transacaoRepository.save(transacao);
		return saqueDTO;
	}

	public DepositoDTO criarDeposito(Long id, Transacao transacao) {
		transacao.setConta(contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTipoTransacao(TipoTransacao.DEP);
		transacao.setDataTransacao(java.util.Calendar.getInstance().getTime());
		transacao.setSaldoAnterior(transacao.getConta().getSaldo());
		transacao.setSaldoAtual(transacao.getConta().getSaldo());
		transacao.setValor(transacao.getValor());
		DepositoDTO depositoDTO = new DepositoDTO();
		double valorDeposito = transacao.getValor();
		if (valorDeposito < 0.0) {
			throw new IllegalArgumentException("Valor de depósito inválido");
		} else {
			Conta conta = transacao.getConta();
			conta.setSaldo(conta.getSaldo() + valorDeposito);
			transacao.setSaldoAtual(conta.getSaldo());
		}
		transacaoMapper.updateDepositoDtoFromTransacao(transacao, depositoDTO);
		transacaoRepository.save(transacao);
		return depositoDTO;
	}

	public TransferenciaDTO criarTransferencia(Long contaId, Long contaDestinoId,Transacao transacao){
		transacao.setConta(contaRepository.findById(contaId).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTipoTransacao(TipoTransacao.TRA);
		transacao.setDataTransacao(java.util.Calendar.getInstance().getTime());
		transacao.setSaldoAnterior(transacao.getConta().getSaldo());
		transacao.setSaldoAtual(transacao.getConta().getSaldo());
		transacao.setValor(transacao.getValor());
		transacao.setContaDestino(contaRepository.findById(contaDestinoId).orElseThrow(() -> new IllegalArgumentException("Conta inexistente")));

		TransferenciaDTO transferenciaDTO = new TransferenciaDTO();
		double valorTransferencia = transacao.getValor();
		if (valorTransferencia < 0.0) {
			throw new IllegalArgumentException("Valor de transferência inválido");
		} else if (valorTransferencia >= transacao.getSaldoAtual()) {
			throw new IllegalArgumentException("Valor de saque maior que o saldo disponível");
		} else {
			Conta conta = transacao.getConta();
			Conta contaDestino = transacao.getConta();
			conta.setSaldo(conta.getSaldo() - valorTransferencia);
			contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
			transacao.setSaldoAtual(conta.getSaldo());
		}
		transacaoMapper.updateTransferenciaDtoFromTransacao(transacao, transferenciaDTO);
		transacaoRepository.save(transacao);
		return transferenciaDTO;
	}
}


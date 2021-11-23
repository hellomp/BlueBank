package com.bluebank.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.DepositoDTO;
import com.bluebank.project.dtos.SaqueDTO;
import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.mappers.TransacaoMapper;
import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.ContaRepository;
import com.bluebank.project.repositories.EmprestimoRepository;
import com.bluebank.project.repositories.TransacaoRepository;

/**
 * TODO: - [x] Deixar apenas o método criar transação - [x] Criar sobrecarga de
 * método para criar Transação (Emprestimo e sem emprestimo)
 * 
 */

@Service
public class TransacaoService {

	@Autowired
	TransacaoRepository transacaoRepository;

	@Autowired
	EmprestimoRepository emprestimoRepository;

	@Autowired
	ContaRepository contaRepository;

	@Autowired
	TransacaoMapper transacaoMapper;

	public List<Transacao> findAll() {
		return this.transacaoRepository.findAll();
	}

	public List<Transacao> findByCpfCnpj(String cpfcnpj) {
		return this.transacaoRepository.findByContaId_ClienteId_Cpfcnpj(cpfcnpj);
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
	

	public Transacao criarTransacao(Transacao transacao) {
		return this.transacaoRepository.save(transacao);
	}
	
	public Transacao criarTransacao(Transacao transacao, Long emprestimoId) throws IllegalArgumentException {
		Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
				.orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
		transacao.setEmprestimo(emprestimo);
		return this.transacaoRepository.save(transacao);
	}

	public Emprestimo criarEmprestimo(Emprestimo emprestimo) {
		return this.emprestimoRepository.save(emprestimo);
	}

}

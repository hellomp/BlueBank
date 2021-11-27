package com.bluebank.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.DepositDTO;
import com.bluebank.project.dtos.WithdrawDTO;
import com.bluebank.project.dtos.TransferenceDTO;
import com.bluebank.project.enums.TransactionTypeEnum;
import com.bluebank.project.mappers.TransactionMapper;
import com.bluebank.project.models.Account;
import com.bluebank.project.models.Transaction;
import com.bluebank.project.repositories.ClientRepository;
import com.bluebank.project.repositories.AccountRepository;
import com.bluebank.project.repositories.TransactionRepository;

@Service
public class TransacaoService {

  @Autowired
  TransactionRepository transacaoRepository;
  
  @Autowired
  AccountRepository contaRepository;

  @Autowired
  ClientRepository clienteRepository;

  @Autowired
  TransactionMapper transacaoMapper;

  @Transactional
  public List<Transaction> findAll(){
    return this.transacaoRepository.findAll();
  }

  @Transactional
  public List<Transaction> findByCpfCnpj(String cpfcnpj){
    return this.transacaoRepository.findByAccountId_ClientId_Cpfcnpj(cpfcnpj);
  }
  
  @Transactional
  public Transaction criarTransacao(Transaction transacao){
    return this.transacaoRepository.save(transacao);
  }

  public List<Object> findByContaId(Long id){
		List <Transaction> transacoes = transacaoRepository.findByAccountId(id);
		return transacaoMapper.updateDtoFromTransacoes(transacoes);
	}
	
	public double findSaldo(Long id) {
		Account conta = contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente"));
		return conta.getBalance();
	}

	public WithdrawDTO criarSaque(Long id, Transaction transacao) {
		transacao.setAccount(contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTransactionType(TransactionTypeEnum.SAQ);
		transacao.setTransactionDate(java.util.Calendar.getInstance().getTime());
		transacao.setPreviousBalance(transacao.getAccount().getBalance());
		transacao.setCurrentBalance(transacao.getAccount().getBalance());
		transacao.setValue(transacao.getValue());
		WithdrawDTO saqueDTO = new WithdrawDTO();
		double valorSaque = transacao.getValue();
		if (valorSaque >= transacao.getCurrentBalance()) {
			throw new IllegalArgumentException("Valor de saque maior que o saldo disponível");
		} else {
			Account conta = transacao.getAccount();
			conta.setBalance(conta.getBalance() - valorSaque);
			transacao.setCurrentBalance(conta.getBalance());
		}
		transacaoMapper.updateWithdrawDtoFromTransaction(transacao, saqueDTO);
		transacaoRepository.save(transacao);
		return saqueDTO;
	}

	public DepositDTO criarDeposito(Long id, Transaction transacao) {
		transacao.setAccount(contaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTransactionType(TransactionTypeEnum.DEP);
		transacao.setTransactionDate(java.util.Calendar.getInstance().getTime());
		transacao.setPreviousBalance(transacao.getAccount().getBalance());
		transacao.setCurrentBalance(transacao.getAccount().getBalance());
		transacao.setValue(transacao.getValue());
		DepositDTO depositoDTO = new DepositDTO();
		double valorDeposito = transacao.getValue();
		if (valorDeposito < 0.0) {
			throw new IllegalArgumentException("Valor de depósito inválido");
		} else {
			Account conta = transacao.getAccount();
			conta.setBalance(conta.getBalance() + valorDeposito);
			transacao.setCurrentBalance(conta.getBalance());
		}
		transacaoMapper.updateDepositDtoFromTransaction(transacao, depositoDTO);
		transacaoRepository.save(transacao);
		return depositoDTO;
	}

	public TransferenceDTO criarTransferencia(Long contaId, Long contaDestinoId,Transaction transacao){
		transacao.setAccount(contaRepository.findById(contaId).orElseThrow(() -> new IllegalArgumentException("Conta Inexistente")));
		transacao.setTransactionType(TransactionTypeEnum.TRA);
		transacao.setTransactionDate(java.util.Calendar.getInstance().getTime());
		transacao.setPreviousBalance(transacao.getAccount().getBalance());
		transacao.setCurrentBalance(transacao.getAccount().getBalance());
		transacao.setValue(transacao.getValue());
		transacao.setDestinationAccount(contaRepository.findById(contaDestinoId).orElseThrow(() -> new IllegalArgumentException("Conta inexistente")));

		TransferenceDTO transferenciaDTO = new TransferenceDTO();
		double valorTransferencia = transacao.getValue();
		if (valorTransferencia <= 0.0) {
			throw new IllegalArgumentException("Valor de transferência inválido");
		} else if (valorTransferencia >= transacao.getCurrentBalance()) {
			throw new IllegalArgumentException("Valor de saque maior que o saldo disponível");
		} else {
			Account conta = transacao.getAccount();
			Account contaDestino = transacao.getDestinationAccount();
			conta.setBalance(conta.getBalance() - valorTransferencia);
			contaDestino.setBalance(contaDestino.getBalance() + valorTransferencia);
			transacao.setCurrentBalance(conta.getBalance());
		}
		transacaoMapper.updateTransferenceDtoFromTransaction(transacao, transferenciaDTO);
		transacaoRepository.save(transacao);
		return transferenciaDTO;
	}
}


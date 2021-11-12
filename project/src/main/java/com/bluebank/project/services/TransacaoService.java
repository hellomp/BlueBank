package com.bluebank.project.services;

import java.util.List;

import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.EmprestimoRepository;
import com.bluebank.project.repositories.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService {

  @Autowired
  TransacaoRepository transacaoRepository;

  @Autowired
  EmprestimoRepository emprestimoRepository;

  public List<Transacao> findAll(){
    return this.transacaoRepository.findAll();
  }

  public Transacao findByCpfCnpj(String cpfcnpj){
    return this.transacaoRepository.findByCpfCnpj(cpfcnpj);
  }
  
  public Transacao criarTransacao(Transacao transacao){
    return this.transacaoRepository.save(transacao);
  }

  public Emprestimo criarEmprestimo(Emprestimo emprestimo){
    return this.emprestimoRepository.save(emprestimo);
  }

  public Transacao criarTrasnferencia(Conta contaDestino){
    return this.transacaoRepository.criarTransferencia(contaDestino);
  }

}

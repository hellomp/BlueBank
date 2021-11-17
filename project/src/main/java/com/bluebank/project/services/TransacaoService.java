package com.bluebank.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.ContaRepository;
import com.bluebank.project.repositories.EmprestimoRepository;
import com.bluebank.project.repositories.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO:
 * - [x] Deixar apenas o método criar transação
 * - [x] Criar sobrecarga de método para criar Transação (Emprestimo e sem emprestimo)
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

  public List<Transacao> findAll(){
    return this.transacaoRepository.findAll();
  }

  public List<Transacao> findByCpfCnpj(String cpfcnpj){
    return this.transacaoRepository.findByContaId_ClienteId_Cpfcnpj(cpfcnpj);
  }
  
  public Transacao criarTransacao(Transacao transacao){
    return this.transacaoRepository.save(transacao);
  }

  public Transacao criarTransacao(Transacao transacao, Long emprestimoId) throws IllegalArgumentException{
    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    transacao.setEmprestimo(emprestimo);
    return this.transacaoRepository.save(transacao);
  }

  public Emprestimo criarEmprestimo(Emprestimo emprestimo){
    return this.emprestimoRepository.save(emprestimo);
  }

}

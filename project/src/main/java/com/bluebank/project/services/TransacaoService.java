package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.mappers.TransacaoMapper;
import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.ClienteRepository;
import com.bluebank.project.repositories.ContaRepository;
import com.bluebank.project.repositories.EmprestimoRepository;
import com.bluebank.project.repositories.TransacaoRepository;

@Service
public class TransacaoService {

  @Autowired
  TransacaoRepository transacaoRepository;

  @Autowired
  EmprestimoRepository emprestimoRepository;
  
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
  public Emprestimo consultarEmprestimoId(Long emprestimoId){
    return this.emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
  }

  //FIXME: Completar consulta por cpfcnpj
  @Transactional
  public List<Emprestimo> consultarEmprestimoCpfcnpj(String cpfcnpj){
    return new ArrayList<Emprestimo>();
  }
  
  @Transactional
  public Transacao criarTransacao(Transacao transacao){
    return this.transacaoRepository.save(transacao);
  }

  @Transactional
  public Transacao criarTransacao(Transacao transacao, Long emprestimoId) throws IllegalArgumentException{
    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    transacao.setEmprestimo(emprestimo);
    return this.transacaoRepository.save(transacao);
  }

  @Transactional
  public EmprestimoDTO criarEmprestimo(String cpfcnpj, Emprestimo emprestimo){
    EmprestimoDTO emprestimoDTOAux = new EmprestimoDTO();
    Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
    transacaoMapper.updateEmprestimoDtoFromEmprestimo(novoEmprestimo, emprestimoDTOAux);
    
    Transacao novaTransacao = new Transacao();
    novaTransacao.setCliente(clienteRepository.findByCpfcnpj(cpfcnpj));
    novaTransacao.setTipoTransacao(TipoTransacao.EMP);
    novaTransacao.setDataTransacao(java.util.Calendar.getInstance().getTime());
    
    this.criarTransacao(novaTransacao, novoEmprestimo.getId());
    return emprestimoDTOAux;
  }

}

package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.mappers.EmprestimoMapper;
import com.bluebank.project.models.Emprestimo;
import com.bluebank.project.models.Transacao;
import com.bluebank.project.repositories.ClienteRepository;
import com.bluebank.project.repositories.EmprestimoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmprestimoService {

  @Autowired
  EmprestimoRepository emprestimoRepository;

  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  EmprestimoMapper emprestimoMapper;

  @Transactional
  public EmprestimoDTO criarEmprestimo(String cpfcnpj, Emprestimo emprestimo){
    EmprestimoDTO emprestimoDTOAux = new EmprestimoDTO();
    Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
    emprestimoMapper.updateEmprestimoDtoFromEmprestimo(novoEmprestimo, emprestimoDTOAux);
    
    Transacao novaTransacao = new Transacao();
    novaTransacao.setCliente(clienteRepository.findByCpfcnpj(cpfcnpj));
    novaTransacao.setTipoTransacao(TipoTransacao.EMP);
    novaTransacao.setDataTransacao(java.util.Calendar.getInstance().getTime());
    
    this.criarTransacao(novaTransacao, novoEmprestimo.getId());
    return emprestimoDTOAux;
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
  
}

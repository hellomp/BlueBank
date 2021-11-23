package com.bluebank.project.services;

import java.util.List;

import com.bluebank.project.dtos.EmprestimoDTO;
import com.bluebank.project.mappers.EmprestimoMapper;
import com.bluebank.project.models.Emprestimo;
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
    emprestimo.setCliente(clienteRepository.findByCpfcnpj(cpfcnpj));

    EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
    emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimoRepository.save(emprestimo), emprestimoDTO);
    return emprestimoDTO;
  }

  @Transactional
  public Emprestimo consultarEmprestimoId(Long emprestimoId) throws IllegalArgumentException{
    return this.emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
  }

  //FIXME: Completar consulta por cpfcnpj
  @Transactional
  public List<Emprestimo> consultarEmprestimoCpfcnpj(String cpfcnpj){
    return this.emprestimoRepository.findByClienteId_Cpfcnpj(cpfcnpj);
  }
  
}

package com.bluebank.project.services;

import java.util.ArrayList;
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
  public EmprestimoDTO consultarEmprestimoId(Long emprestimoId) throws IllegalArgumentException{
    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    return emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimo, new EmprestimoDTO());
  }

  //FIXME: Completar consulta por cpfcnpj
  @Transactional
  public List<EmprestimoDTO> consultarEmprestimoCpfcnpj(String cpfcnpj){
    List<EmprestimoDTO> listEmprestimoDTO = new ArrayList<EmprestimoDTO>();
    for(Emprestimo emprestimo : emprestimoRepository.findByClienteId_Cpfcnpj(cpfcnpj)){
      listEmprestimoDTO.add(emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimo, new EmprestimoDTO()));
    }
    return listEmprestimoDTO;
  }

  @Transactional
  public double pagarEmprestimo(Long emprestimoId, Long contaId) throws IllegalArgumentException{
    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));

    double valorPagamento = (emprestimo.getValorEmprestimo() / emprestimo.getQuantParcelas()) + (emprestimo.getValorEmprestimo() * emprestimo.getPercentualJuros());
    return valorPagamento;
  }
  
}

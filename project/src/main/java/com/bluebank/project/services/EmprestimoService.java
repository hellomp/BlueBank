package com.bluebank.project.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluebank.project.dtos.LoanDTO;
import com.bluebank.project.dtos.TransferenceDTO;
import com.bluebank.project.mappers.LoanMapper;
import com.bluebank.project.mappers.TransactionMapper;
import com.bluebank.project.models.Loan;
import com.bluebank.project.models.Transaction;
import com.bluebank.project.repositories.ClientRepository;
import com.bluebank.project.repositories.AccountRepository;
import com.bluebank.project.repositories.LoanRepository;

@Service
public class EmprestimoService {

  @Autowired
  LoanRepository emprestimoRepository;

  @Autowired
  ClientRepository clienteRepository;

  @Autowired
  AccountRepository contaRepository;

  @Autowired
  LoanMapper emprestimoMapper;

  @Autowired
  TransactionMapper transacaoMapper;

  @Autowired
  TransacaoService transacaoService;

  @Transactional
  public LoanDTO criarEmprestimo(String cpfcnpj, Loan emprestimo){
    emprestimo.setClient(clienteRepository.findByCpfcnpj(cpfcnpj));

    LoanDTO emprestimoDTO = new LoanDTO();
    emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimoRepository.save(emprestimo), emprestimoDTO);
    return emprestimoDTO;
  }

  @Transactional
  public LoanDTO consultarEmprestimoId(Long emprestimoId) throws IllegalArgumentException{
    Loan emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    return emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimo, new LoanDTO());
  }

  @Transactional
  public List<LoanDTO> consultarEmprestimoCpfcnpj(String cpfcnpj){
    List<LoanDTO> listEmprestimoDTO = new ArrayList<LoanDTO>();
    for(Loan emprestimo : emprestimoRepository.findByClientId_Cpfcnpj(cpfcnpj)){
      listEmprestimoDTO.add(emprestimoMapper.updateEmprestimoDtoFromEmprestimo(emprestimo, new LoanDTO()));
    }
    return listEmprestimoDTO;
  }

  @Transactional
  public TransferenceDTO pagarEmprestimo(Long emprestimoId, Long contaId) throws IllegalArgumentException{
    Loan emprestimo = emprestimoRepository.findById(emprestimoId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    double valorPagamento = (emprestimo.getBorrowedAmount() / emprestimo.getInstallments()) + (emprestimo.getBorrowedAmount() * emprestimo.getFees());
    
    Transaction transacao = new Transaction();
    transacao.setValue(valorPagamento);

    return transacaoService.criarTransferencia(contaId, 1L, transacao);
  }
  
}

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
public class LoanService {

  @Autowired
  LoanRepository loanRepository;

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  LoanMapper loanMapper;

  @Autowired
  TransactionMapper transactionMapper;

  @Autowired
  TransactionService transactionService;

  @Transactional
  public LoanDTO createLoan(String cpfcnpj, Loan loan){
    loan.setClient(clientRepository.findByCpfcnpj(cpfcnpj));

    LoanDTO loanDTO = new LoanDTO();
    loanMapper.updateEmprestimoDtoFromEmprestimo(loanRepository.save(loan), loanDTO);
    return loanDTO;
  }

  @Transactional
  public LoanDTO showLoanById(Long loanId) throws IllegalArgumentException{
    Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    return loanMapper.updateEmprestimoDtoFromEmprestimo(loan, new LoanDTO());
  }

  @Transactional
  public List<LoanDTO> showLoanByClientCpfcnpj(String cpfcnpj){
    List<LoanDTO> listLoanDTO = new ArrayList<LoanDTO>();
    for(Loan loan : loanRepository.findByClientId_Cpfcnpj(cpfcnpj)){
      listLoanDTO.add(loanMapper.updateEmprestimoDtoFromEmprestimo(loan, new LoanDTO()));
    }
    return listLoanDTO;
  }

  @Transactional
  public TransferenceDTO payLoan(Long loanId, Long accountId) throws IllegalArgumentException{
    Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new IllegalArgumentException("Emprestimo não encontrado"));
    double moneyAmount = (loan.getBorrowedAmount() / loan.getInstallments()) + (loan.getBorrowedAmount() * loan.getFees());
    
    Transaction transaction = new Transaction();
    transaction.setValue(moneyAmount);

    return transactionService.transferAmount(accountId, 1L, transaction);
  }
  
}

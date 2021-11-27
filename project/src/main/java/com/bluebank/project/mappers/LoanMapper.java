package com.bluebank.project.mappers;

import com.bluebank.project.dtos.LoanDTO;
import com.bluebank.project.models.Loan;

import org.springframework.stereotype.Service;

@Service
public class LoanMapper {

	public LoanDTO updateEmprestimoDtoFromEmprestimo(Loan loan, LoanDTO loanDTO) {
		loanDTO.setClientCpfcnpj(loan.getClient().getCpfcnpj());
	    loanDTO.setContractNumber(loan.getId());
	    loanDTO.setStartDate(loan.getStartDate().toString());
		loanDTO.setEndDate(loan.getEndDate().toString());
		loanDTO.setBorrowedAmount(loan.getBorrowedAmount());
		loanDTO.setFees(loan.getFees());
		loanDTO.setInstallments(loan.getInstallments());
		return loanDTO;
	}
}

package com.bluebank.project.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bluebank.project.dtos.DepositDTO;
import com.bluebank.project.dtos.LoanDTO;
import com.bluebank.project.dtos.WithdrawDTO;
import com.bluebank.project.dtos.TransferenceDTO;
import com.bluebank.project.models.Loan;
import com.bluebank.project.models.Transaction;

@Service
public class TransactionMapper {

	public List <Object> updateDtoFromTransacoes(List <Transaction> transactions) {
		List <Object> transacoesDTO = new ArrayList<>();
		for (Transaction transacao : transactions) {
			switch (transacao.getTransactionType()) {
			case DEP:
				DepositDTO depositoDTO = new DepositDTO();
				updateDepositDtoFromTransaction(transacao, depositoDTO);
				transacoesDTO.add(depositoDTO);
				break;
			case SAQ:
				WithdrawDTO saqueDTO = new WithdrawDTO();
				updateWithdrawDtoFromTransaction(transacao, saqueDTO);
				transacoesDTO.add(saqueDTO);
				break;
			case TRA:
				TransferenceDTO transferenciaDTO = new TransferenceDTO();
				updateTransferenceDtoFromTransaction(transacao, transferenciaDTO);
				transacoesDTO.add(transacoesDTO);
				break;
			}		
		}
		return transacoesDTO;
	}	
	
	public DepositDTO updateDepositDtoFromTransaction(Transaction transaction, DepositDTO depositDTO) {
		depositDTO.setTransactionDate(transaction.getTransactionDate().toString());
		depositDTO.setTransactionType(transaction.getTransactionType()); // TODO: pegar string do nome completo
		depositDTO.setPreviousBalance(transaction.getPreviousBalance());
		depositDTO.setCurrentBalance(transaction.getCurrentBalance());
		depositDTO.setDepositValue(transaction.getValue());
		return depositDTO;
	}

	public LoanDTO updateLoanDtoFromLoan(Loan loan, LoanDTO loanDTO) {
		loanDTO.setNumeroContrato(loan.getNumeroContrato());
		loanDTO.setStartDate(loan.getStartDate().toString());
		loanDTO.setEndDate(loan.getEndDate().toString());
		loanDTO.setBorrowedAmount(loan.getBorrowedAmount());
		loanDTO.setFees(loan.getFees());
		loanDTO.setInstallments(loan.getInstallments());
		return loanDTO;
	}
	
	public WithdrawDTO updateWithdrawDtoFromTransaction(Transaction transaction, WithdrawDTO withdrawDTO) {
		withdrawDTO.setTransactionType(transaction.getTransactionType()); // TODO: pegar string do nome completo
		withdrawDTO.setTransactionDate(transaction.getTransactionDate().toString());
		withdrawDTO.setPreviousBalance(transaction.getPreviousBalance());
		withdrawDTO.setCurrentBalance(transaction.getCurrentBalance());
		withdrawDTO.setWithdrawValue(transaction.getValue());
		return withdrawDTO;
	}

	public TransferenceDTO updateTransferenceDtoFromTransaction(Transaction transaction, TransferenceDTO transferenceDTO) {
		transferenceDTO.setAccount(transaction.getAccount()); // TODO: mudar para ID
		transferenceDTO.setTransactionType(transaction.getTransactionType()); // TODO: pegar string do nome completo
		transferenceDTO.setTransactionDate(transaction.getTransactionDate().toString());
		transferenceDTO.setPreviousBalance(transaction.getPreviousBalance());
		transferenceDTO.setCurrentBalance(transaction.getCurrentBalance());
		transferenceDTO.setDestinationAccount(transaction.getDestinationAccount());
		transferenceDTO.setScheduledDate(transaction.getDataAgendTransacao().toString());
		transferenceDTO.setDataExecTransacao(transaction.getDataExecTransacao().toString());
		transferenceDTO.setValue(transaction.getValue());
		return transferenceDTO;
	}

}

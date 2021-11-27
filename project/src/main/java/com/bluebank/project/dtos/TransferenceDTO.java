package com.bluebank.project.dtos;

import com.bluebank.project.enums.TransactionTypeEnum;
import com.bluebank.project.models.Account;

public class TransferenceDTO {

	private Account account;
	private TransactionTypeEnum transactionType;
	private String transactionDate;
	private double previousBalance;
	private double currentBalance;
	private Account destinationAccount;
	private String scheduledDate; // TODO: verificar se é possível usar isso no lambda
	private String dataExecTransacao;
	private Double value;
	  
	public TransferenceDTO() {
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public TransactionTypeEnum getTransactionType() {
		return transactionType;
	}
	
	public void setTransactionType(TransactionTypeEnum transactionType) {
		this.transactionType = transactionType;
	}
	
	public String getTransactionDate() {
		return transactionDate;
	}
	
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public double getPreviousBalance() {
		return previousBalance;
	}
	
	public void setPreviousBalance(double previousBalance) {
		this.previousBalance = previousBalance;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public Account getDestinationAccount() {
		return destinationAccount;
	}
	
	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	
	public String getScheduledDate() {
		return scheduledDate;
	}
	
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	public String getDataExecTransacao() {
		return dataExecTransacao;
	}
	
	public void setDataExecTransacao(String dataExecTransacao) {
		this.dataExecTransacao = dataExecTransacao;
	}
	
	public Double getValue() {
		return value;
	}
	
	public void setValue(Double value) {
		this.value = value;
	}
  
}

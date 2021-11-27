package com.bluebank.project.dtos;


import com.bluebank.project.enums.TransactionTypeEnum;

public class DepositDTO {
  
	private TransactionTypeEnum transactionType;
	private String transactionDate;
	private double previousBalance;
	private double depositValue;
	private double currentBalance;
  
	public DepositDTO() {
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

	public double getDepositValue() {
		return depositValue;
	}

	public void setDepositValue(double depositValue) {
		this.depositValue = depositValue;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

}

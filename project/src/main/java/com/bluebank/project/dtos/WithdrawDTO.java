package com.bluebank.project.dtos;

import com.bluebank.project.enums.TransactionTypeEnum;

public class WithdrawDTO {
  
	private TransactionTypeEnum transactionType;
	private String transactionDate;
	private double previousBalance;
	private double withdrawValue;
	private double currentBalance;
 
	public WithdrawDTO() {
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

	public double getWithdrawValue() {
		return withdrawValue;
	}

	public void setWithdrawValue(double withdrawValue) {
		this.withdrawValue = withdrawValue;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}  
  
}

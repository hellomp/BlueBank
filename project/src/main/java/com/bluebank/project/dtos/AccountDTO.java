package com.bluebank.project.dtos;

import com.bluebank.project.enums.AccountTypeEnum;

public class AccountDTO {

	private Long id;
	private String clientName;
	private int agency;
	private AccountTypeEnum accountType;
	private String status;
	private double currentBalance;
	
	public AccountDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getAgency() {
		return agency;
	}

	public void setAgency(int agency) {
		this.agency = agency;
	}

	public AccountTypeEnum getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountTypeEnum accountType) {
		this.accountType = accountType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double actualBalance) {
		this.currentBalance = actualBalance;
	}
	
}

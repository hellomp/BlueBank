package com.bluebank.project.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.enums.AccountTypeEnum;

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Client client;
	
	private int agency;
	
//	@NotBlank
	private AccountTypeEnum accountType;
	
	private Date dateForReference;
	
	private double balance;
	
	private AccountStatusEnum status;
	
	public Account() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

	public Date getDateForReference() {
		return dateForReference;
	}

	public void setDateForReference(Date dateForReference) {
		this.dateForReference = dateForReference;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountStatusEnum getStatus() {
		return status;
	}

	public void setStatus(AccountStatusEnum status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", client=" + client + ", agency=" + agency + ", accountType=" + accountType
				+ ", dateForReference=" + dateForReference + ", balance=" + balance + ", status=" + status + "]";
	}

}

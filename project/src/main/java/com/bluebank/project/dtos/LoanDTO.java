package com.bluebank.project.dtos;

public class LoanDTO {
	
	private String clientCpfcnpj;
	private String numeroContrato; // TODO: usar Id
	private String startDate;
	private String endDate;
	private double borrowedAmount;
	private double fees;
	private int installments;
  
    public LoanDTO() {
    }

	public String getClientCpfcnpj() {
		return clientCpfcnpj;
	}
	
	public void setClientCpfcnpj(String clientCpfcnpj) {
		this.clientCpfcnpj = clientCpfcnpj;
	}
	
	public String getNumeroContrato() {
		return numeroContrato;
	}
	
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public double getBorrowedAmount() {
		return borrowedAmount;
	}
	
	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}
	
	public double getFees() {
		return fees;
	}
	
	public void setFees(double fees) {
		this.fees = fees;
	}
	
	public int getInstallments() {
		return installments;
	}
	
	public void setInstallments(int installments) {
		this.installments = installments;
	}

}

package com.bluebank.project.dtos;

public class LoanDTO {
	
	private String clientCpfcnpj;
	private Long contractNumber;
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
	
	public Long getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(Long numeroContrato) {
		this.contractNumber = numeroContrato;
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

package com.bluebank.project.dtos;

import java.util.Date;
import com.bluebank.project.enums.ContaEnum;
import com.bluebank.project.models.Cliente;

public class AccountDTO {

//	private ClientDTO clientDTO;
	private Long id;
	private String nomeDoCliente;
	private int agencia;
	private ContaEnum tipoConta;
	private String status;
	private double saldoAtual;
	
	public AccountDTO() {
		super();
	}
	
//	public ClientDTO getClientDTO() {
//		return clientDTO;
//	}
//	
//	public void setClientDTO(ClientDTO clientDTO) {
//		this.clientDTO = clientDTO;
//	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public ContaEnum getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(ContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public double getSaldoAtual() {
		return saldoAtual;
	}
	
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomeDoCliente() {
		return nomeDoCliente;
	}

	public void setNomeDoCliente(String nomeDoCliente) {
		this.nomeDoCliente = nomeDoCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

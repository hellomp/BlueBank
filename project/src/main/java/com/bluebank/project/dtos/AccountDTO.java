package com.bluebank.project.dtos;

import java.util.Date;
import com.bluebank.project.enums.ContaEnum;
import com.bluebank.project.models.Cliente;

public class AccountDTO {

	private Cliente cliente;
	private int agencia;
	private ContaEnum tipoConta;
	private Date dataAbertura;
	private Date dataEncerramento;
	private double saldoAtual;
	
	public AccountDTO() {
		super();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
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
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public double getSaldoAtual() {
		return saldoAtual;
	}
	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
	}
	
	
}

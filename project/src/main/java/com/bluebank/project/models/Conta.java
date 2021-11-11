package com.bluebank.project.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.bluebank.project.enums.ContaEnum;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@NotBlank
	@Column(name = "id_agencia")
	private int agencia;
	
	@NotBlank
	@Column(name = "tipo_conta")
	private ContaEnum tipoConta;
	
	@NotBlank
	@Column(name = "dt_abertura")
	private Date dataAbertura;
	
	@Column(name = "dt_encerramento")
	private Date dataEncerramento;
	
	@NotBlank
	@Column(name = "saldo_inicial")
	private double sladoInicial;
	
	@NotBlank
	@Column(name = "sado_anterior")
	private double saldoAnterior;
	
	@Column(name = "saldo_atual")
	private double saldoAtual;
	
	public Conta() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getIdAgencia() {
		return agencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.agencia = idAgencia;
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

	public double getSladoInicial() {
		return sladoInicial;
	}

	public void setSladoInicial(double sladoInicial) {
		this.sladoInicial = sladoInicial;
	}

	public double getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(double saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public double getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(double saldoAtual) {
		this.saldoAtual = saldoAtual;
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
		Conta other = (Conta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", cliente=" + cliente + ", idAgencia=" + agencia + ", tipoConta=" + tipoConta
				+ ", dataAbertura=" + dataAbertura + ", dataEncerramento=" + dataEncerramento + ", sladoInicial="
				+ sladoInicial + ", saldoAnterior=" + saldoAnterior + ", saldoAtual=" + saldoAtual + "]";
	}
	
	
}

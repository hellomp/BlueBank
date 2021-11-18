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

import com.bluebank.project.enums.AccountStatusEnum;
import com.bluebank.project.enums.ContaEnum;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
//	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
//	@NotBlank
//	@Column(name = "id_agencia")
	private int agencia;
	
//	@NotBlank
//	@Column(name = "tipo_conta")
	private ContaEnum tipoConta;
	
//	@Column(name = "dt_abertura")
	private Date dateForReference;
	
	private double saldo;
	
	private AccountStatusEnum status;
	
	public Conta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateForReference() {
		return dateForReference;
	}

	public void setDateForReference(Date dataForReference) {
		this.dateForReference = dataForReference;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
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
		Conta other = (Conta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", cliente=" + cliente + ", agencia=" + agencia + ", tipoConta=" + tipoConta
				+ ", dataForReference=" + dateForReference + ", saldo=" + saldo + ", status=" + status + "]";
	}
	
}

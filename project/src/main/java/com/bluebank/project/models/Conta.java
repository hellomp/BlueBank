package com.bluebank.project.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.bluebank.project.enums.ContaEnum;

@Entity
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private int id_cliente;
	@NotBlank
	private int id_agencia;
	@NotBlank
	private ContaEnum tipo_conta;
	@NotBlank
	private Date dt_abertura;
	private Date dt_encerramento;
	@NotBlank
	private double saldo_inicial;
	@NotBlank
	private double saldo_anterior;
	private double saldo_atual;
	
	@ManyToOne
	private Cliente cliente;
	
	public Conta() {
		
	}

	public Conta(int id, int id_cliente, int id_agencia, ContaEnum tipo_conta, Date dt_abertura, Date dt_encerramento,
			double saldo_inicial, double saldo_anterior, double saldo_atual, Cliente cliente) {
		super();
		this.id = id;
		this.id_cliente = id_cliente;
		this.id_agencia = id_agencia;
		this.tipo_conta = tipo_conta;
		this.dt_abertura = dt_abertura;
		this.dt_encerramento = dt_encerramento;
		this.saldo_inicial = saldo_inicial;
		this.saldo_anterior = saldo_anterior;
		this.saldo_atual = saldo_atual;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_agencia() {
		return id_agencia;
	}

	public void setId_agencia(int id_agencia) {
		this.id_agencia = id_agencia;
	}

	public ContaEnum getTipo_conta() {
		return tipo_conta;
	}

	public void setTipo_conta(ContaEnum tipo_conta) {
		this.tipo_conta = tipo_conta;
	}

	public Date getDt_abertura() {
		return dt_abertura;
	}

	public void setDt_abertura(Date dt_abertura) {
		this.dt_abertura = dt_abertura;
	}

	public Date getDt_encerramento() {
		return dt_encerramento;
	}

	public void setDt_encerramento(Date dt_encerramento) {
		this.dt_encerramento = dt_encerramento;
	}

	public double getSaldo_inicial() {
		return saldo_inicial;
	}

	public void setSaldo_inicial(double saldo_inicial) {
		this.saldo_inicial = saldo_inicial;
	}

	public double getSaldo_anterior() {
		return saldo_anterior;
	}

	public void setSaldo_anterior(double saldo_anterior) {
		this.saldo_anterior = saldo_anterior;
	}

	public double getSaldo_atual() {
		return saldo_atual;
	}

	public void setSaldo_atual(double saldo_atual) {
		this.saldo_atual = saldo_atual;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		return "Conta [id=" + id + ", id_cliente=" + id_cliente + ", id_agencia=" + id_agencia + ", tipo_conta="
				+ tipo_conta + ", dt_abertura=" + dt_abertura + ", dt_encerramento=" + dt_encerramento
				+ ", saldo_inicial=" + saldo_inicial + ", saldo_anterior=" + saldo_anterior + ", saldo_atual="
				+ saldo_atual + "]";
	}

	
	
	
}

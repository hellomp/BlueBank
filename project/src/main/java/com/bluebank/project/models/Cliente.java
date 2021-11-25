package com.bluebank.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;

import com.bluebank.project.enums.ClientStatusEnum;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	@JoinColumn(name = "nome")
	private String nome;
	
	@NotBlank
	@Column(unique = true)
	@JoinColumn(name = "cpfcnpj")
	private String cpfcnpj;
	
	@NotBlank
	@JoinColumn(name = "email")
	private String email;
	
	@NotBlank
	@JoinColumn(name = "cep")
	private String cep;
	
	@NotBlank
	@JoinColumn(name = "telefone")
	private String telefone;
	
	@NotBlank
	@JoinColumn(name = "senha")
	private String senha;
	
	@NotBlank
	@JoinColumn(name = "tipo")
	private String tipo;
	
	private ClientStatusEnum status;
	
	public Cliente() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfcnpj() {
		return cpfcnpj;
	}

	public void setCpfcnpj(String cpfcnpj) {
		this.cpfcnpj = cpfcnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	

	public ClientStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ClientStatusEnum status) {
		this.status = status;
	}	


}

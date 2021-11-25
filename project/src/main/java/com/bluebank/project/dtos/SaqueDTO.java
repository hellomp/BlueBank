package com.bluebank.project.dtos;


import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.models.Conta;

public class SaqueDTO {
  
//  private Conta conta;
  private TipoTransacao tipoTransacao;
  private String dataTransacao;
  private double saldoAnterior;
  private double valorSaque;
  private double saldoAtual;
 

  public SaqueDTO() {
  }

//  public Conta getConta() {
//    return conta;
//  }
//
//  public void setConta(Conta conta) {
//    this.conta = conta;
//  }

  public TipoTransacao getTipoTransacao() {
    return tipoTransacao;
  }

  public void setTipoTransacao(TipoTransacao tipoTransacao) {
    this.tipoTransacao = tipoTransacao;
  }

  public String getDataTransacao() {
    return dataTransacao;
  }

  public void setDataTransacao(String dataTransacao) {
    this.dataTransacao = dataTransacao;
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

public double getValorSaque() {
	return valorSaque;
}

public void setValorSaque(double valor) {
	this.valorSaque = valor;
}
  
  
}

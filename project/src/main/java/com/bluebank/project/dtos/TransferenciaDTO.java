package com.bluebank.project.dtos;

import java.util.Date;

import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.models.Conta;

public class TransferenciaDTO {

  private Conta conta;
  private TipoTransacao tipoTransacao;
  private String dataTransacao;
  private double saldoAnterior;
  private double saldoAtual;
  private Conta contaDestino;
  private String dataAgendTransacao;
  private String dataExecTransacao;
  private Double valor;
  
  public TransferenciaDTO() {
  }

  public Conta getConta() {
    return conta;
  }

  public void setConta(Conta conta) {
    this.conta = conta;
  }

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

  public Conta getContaDestino() {
    return contaDestino;
  }

  public void setContaDestino(Conta contaDestino) {
    this.contaDestino = contaDestino;
  }

  public String getDataAgendTransacao() {
    return dataAgendTransacao;
  }

  public void setDataAgendTransacao(String dataAgendTransacao) {
    this.dataAgendTransacao = dataAgendTransacao;
  }

  public String getDataExecTransacao() {
    return dataExecTransacao;
  }

  public void setDataExecTransacao(String dataExecTransacao) {
    this.dataExecTransacao = dataExecTransacao;
  }

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}
  
  
}

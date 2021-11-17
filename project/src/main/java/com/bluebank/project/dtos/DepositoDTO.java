package com.bluebank.project.dtos;

import java.util.Date;

import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.models.Conta;

public class DepositoDTO {
  
  private Conta conta;
  private TipoTransacao tipoTransacao;
  private Date dataTransacao;
  private double saldoAnterior;
  private double saldoAtual;
  
  public DepositoDTO() {
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

  public Date getDataTransacao() {
    return dataTransacao;
  }

  public void setDataTransacao(Date dataTransacao) {
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

}

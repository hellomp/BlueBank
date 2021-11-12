package com.bluebank.project.dtos;

import java.util.Date;

import com.bluebank.project.enums.TipoTransacao;
import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Emprestimo;

public class TransacaoDTO {
  
  private Conta conta;
  private TipoTransacao tipoTransacao;
  private Date dataTransacao;
  private double saldoAnterior;
  private double saldoAtual;
  private Conta contaDestino;
  private Date dataAgendTransacao;
  private Date dataExecTransacao;
  private Emprestimo emprestimo;
  private double depositoEmprestimo;

  public TransacaoDTO() {
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

  public Conta getContaDestino() {
    return contaDestino;
  }

  public void setContaDestino(Conta contaDestino) {
    this.contaDestino = contaDestino;
  }

  public Date getDataAgendTransacao() {
    return dataAgendTransacao;
  }

  public void setDataAgendTransacao(Date dataAgendTransacao) {
    this.dataAgendTransacao = dataAgendTransacao;
  }

  public Date getDataExecTransacao() {
    return dataExecTransacao;
  }

  public void setDataExecTransacao(Date dataExecTransacao) {
    this.dataExecTransacao = dataExecTransacao;
  }

  public Emprestimo getEmprestimo() {
    return emprestimo;
  }

  public void setEmprestimo(Emprestimo emprestimo) {
    this.emprestimo = emprestimo;
  }

  public double getDepositoEmprestimo() {
    return depositoEmprestimo;
  }

  public void setDepositoEmprestimo(double depositoEmprestimo) {
    this.depositoEmprestimo = depositoEmprestimo;
  }
  
}

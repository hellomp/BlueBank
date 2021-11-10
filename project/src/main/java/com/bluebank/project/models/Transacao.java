package com.bluebank.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.bluebank.project.enums.TipoTransacao;

@Entity
public class Transacao {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @ManyToOne
  @JoinColumn(name = "id_conta")
  private Conta conta;

  @NotNull
  @Column(name = "tipo_trans")
  private TipoTransacao tipoTransacao;

  @NotNull
  @Column(name = "dt_trans")
  private Date dataTransacao;

  @NotNull
  @Column(name = "saldo_anterior")
  private double saldoAnterior;

  @NotNull
  @Column(name = "saldo_atual")
  private double SaldoAtual;
  
  @OneToOne
  @JoinColumn(name = "id_conta_dest")
  private Conta contaDestino;

  @Column(name = "dt_agend_tra")
  private Date dataAgendTransacao;

  @Column(name = "dt_exec_tra")
  private Date dataExecTransacao;

  @OneToOne
  @JoinColumn(name = "id_emp")
  private Emprestimo emprestimo;

  @Column(name = "dep_emp")
  private Double depositoEmprestimo;

  public Transacao() {
    super();
  }

  public Transacao(int id, Conta conta, TipoTransacao tipoTransacao, Date dataTransacao,
      double saldoAnterior, double saldoAtual) {
    this.id = id;
    this.conta = conta;
    this.tipoTransacao = tipoTransacao;
    this.dataTransacao = dataTransacao;
    this.saldoAnterior = saldoAnterior;
    SaldoAtual = saldoAtual;
  }

  public Transacao(int id, Conta conta, TipoTransacao tipoTransacao, Date dataTransacao,
      double saldoAnterior, double saldoAtual, Conta contaDestino, Date dataAgendTransacao,
      Date dataExecTransacao, Emprestimo emprestimo, Double depositoEmprestimo) {
    this.id = id;
    this.conta = conta;
    this.tipoTransacao = tipoTransacao;
    this.dataTransacao = dataTransacao;
    this.saldoAnterior = saldoAnterior;
    SaldoAtual = saldoAtual;
    this.contaDestino = contaDestino;
    this.dataAgendTransacao = dataAgendTransacao;
    this.dataExecTransacao = dataExecTransacao;
    this.emprestimo = emprestimo;
    this.depositoEmprestimo = depositoEmprestimo;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    return SaldoAtual;
  }

  public void setSaldoAtual(double saldoAtual) {
    SaldoAtual = saldoAtual;
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

  public Double getDepositoEmprestimo() {
    return depositoEmprestimo;
  }

  public void setDepositoEmprestimo(Double depositoEmprestimo) {
    this.depositoEmprestimo = depositoEmprestimo;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Transacao other = (Transacao) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Transacao [SaldoAtual=" + SaldoAtual + ", conta=" + conta + ", contaDestino=" + contaDestino
        + ", dataAgendTransacao=" + dataAgendTransacao + ", dataExecTransacao=" + dataExecTransacao + ", dataTransacao="
        + dataTransacao + ", depositoEmprestimo=" + depositoEmprestimo + ", emprestimo=" + emprestimo + ", id=" + id
        + ", saldoAnterior=" + saldoAnterior + ", tipoTransacao=" + tipoTransacao + "]";
  }
  
}
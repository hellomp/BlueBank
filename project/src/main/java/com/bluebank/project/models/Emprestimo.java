package com.bluebank.project.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Emprestimo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @ManyToOne
  private Cliente cliente;

  @NotNull
  @Column(name = "num_contrato")
  private String numeroContrato;

  @NotNull
  @Column(name = "dt_inicio")
  private Date dataInicio;

  @NotNull
  @Column(name = "dt_fim")
  private Date dataFim;

  @NotNull
  @Column(name = "vl_emprestimo")
  private double valorEmprestimo;

  @NotNull
  @Column(name = "per_juros")
  private double percentualJuros;

  @NotNull
  @Column(name = "qt_parcelas")
  private int quantParcelas;

  public Emprestimo() {
    super();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public String getNumeroContrato() {
    return numeroContrato;
  }

  public void setNumeroContrato(String numeroContrato) {
    this.numeroContrato = numeroContrato;
  }

  public Date getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(Date dataInicio) {
    this.dataInicio = dataInicio;
  }

  public Date getDataFim() {
    return dataFim;
  }

  public void setDataFim(Date dataFim) {
    this.dataFim = dataFim;
  }

  public double getValorEmprestimo() {
    return valorEmprestimo;
  }

  public void setValorEmprestimo(double valorEmprestimo) {
    this.valorEmprestimo = valorEmprestimo;
  }

  public double getPercentualJuros() {
    return percentualJuros;
  }

  public void setPercentualJuros(double percentualJuros) {
    this.percentualJuros = percentualJuros;
  }

  public int getQuantParcelas() {
    return quantParcelas;
  }

  public void setQuantParcelas(int quantParcelas) {
    this.quantParcelas = quantParcelas;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
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
    Emprestimo other = (Emprestimo) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Emprestimo [dataFim=" + dataFim + ", dataInicio=" + dataInicio + ", id=" + id + ", numeroContrato="
        + numeroContrato + ", percentualJuros=" + percentualJuros + ", quantParcelas=" + quantParcelas
        + ", valorEmprestimo=" + valorEmprestimo + "]";
  }

}

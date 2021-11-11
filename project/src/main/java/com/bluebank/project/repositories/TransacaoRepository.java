package com.bluebank.project.repositories;

import com.bluebank.project.models.Conta;
import com.bluebank.project.models.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  
  public Transacao findByCpfCnpj(String cpfcnpj);

  public Transacao criarTransferencia(Conta contaDestino);

}

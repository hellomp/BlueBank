package com.bluebank.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebank.project.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  
	public Transacao findByIdContaByIdClienteByCpfcnpj(String cpfcnpj);

}

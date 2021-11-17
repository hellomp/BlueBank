package com.bluebank.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bluebank.project.models.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
  
//	public Transacao findByContaIdByIdClienteByCpfcnpj(String cpfcnpj);
	
	public List<Transacao> findByContaId_ClienteId_Cpfcnpj(String cpfcnpj);

}
